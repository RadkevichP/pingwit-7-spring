package pl.pingwit.springdemo.service.status;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import pl.pingwit.springdemo.controller.user.CreateUserInputDto;
import pl.pingwit.springdemo.controller.user.UpdateUserInputDto;
import pl.pingwit.springdemo.controller.user.UserDto;
import pl.pingwit.springdemo.exception.PingwitException;
import pl.pingwit.springdemo.exception.PingwitNotFoundException;
import pl.pingwit.springdemo.repository.user.User;
import pl.pingwit.springdemo.repository.user.UserRepository;
import pl.pingwit.springdemo.validator.UserValidator;

import java.util.List;
import java.util.Optional;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService {

    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public UserService(
            UserRepository userRepository,
            UserValidator userValidator
    ) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    public List<UserDto> findAll() {
        return userRepository.findAllUsers().stream()
                .map(this::mapToDto)
                .toList();
    }

    public UserDto findUserById(Integer id) {
        Optional<User> userById = userRepository.findUserById(id);
        return userById.map(this::mapToDto)
                .orElseThrow(() -> new PingwitNotFoundException("User not found!"));
    }

    public Integer createUser(CreateUserInputDto input) {
        userValidator.validateOnCreate(input);
        User user = mapToUser(input);

        return userRepository.createUser(user);
    }

    public void updateUser(Integer id, UpdateUserInputDto inputDto) {
        //

        User existingUser = userRepository.findUserById(id)
                .orElseThrow(() -> new PingwitException("User not found!"));

        User userToUpdate = new User(existingUser.id(),
                existingUser.name(),
                inputDto.getSurname(),
                inputDto.getEmail(),
                inputDto.getPhone());

        userRepository.updateUser(userToUpdate);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteUser(id);
    }

    private User mapToUser(CreateUserInputDto input) {
        return new User(null, input.getName(), input.getSurname(), input.getEmail(), input.getPhone());
    }

    private UserDto mapToDto(User user) {
        return new UserDto(user.id(), user.name() + " " + user.surname(), user.email());
    }
}
