package pl.pingwit.springdemo.service;

import org.springframework.stereotype.Service;
import pl.pingwit.springdemo.controller.CreateUserInputDto;
import pl.pingwit.springdemo.controller.UserDto;
import pl.pingwit.springdemo.exception.PingwitException;
import pl.pingwit.springdemo.repository.User;
import pl.pingwit.springdemo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAll() {
        return userRepository.findAllUsers().stream()
                .map(this::mapToDto)
                .toList();
    }

    public UserDto findUserById(Integer id) {
        Optional<User> userById = userRepository.findUserById(id);
        return userById.map(this::mapToDto)
                .orElseThrow(() -> new PingwitException("User not found!"));
    }

    public Integer createUser(CreateUserInputDto input) {
        User user = mapToUser(input);

        return userRepository.createUser(user);
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
