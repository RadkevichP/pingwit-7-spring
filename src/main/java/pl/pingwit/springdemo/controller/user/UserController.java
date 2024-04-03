package pl.pingwit.springdemo.controller.user;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pl.pingwit.springdemo.service.status.UserService;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    // CRUD для сущности User
    private final String greeting;
    private final UserService userService;

    public UserController(@Value("${pingwit.basic.greeting}") String greeting,
                          UserService userService
    ) {
        this.greeting = greeting;
        this.userService = userService;
    }

    // гет-эндпоинт, который принимает имя пользователья как параметр запроса и возвращает строку-приветсвие
    // Tonya -> "Hello, Pavel, my dear friend!
    @GetMapping("/hello")
    public String sayHello(@RequestParam(name = "name") String dummyName,
                           String surname) {
        return String.format(greeting, dummyName + surname);
    }

    @GetMapping
    public List<UserDto> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable(name = "id") Integer id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public Integer createUser(@RequestBody CreateUserInputDto input) {
        return userService.createUser(input);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody UpdateUserInputDto inputDto, @PathVariable(name = "id") Integer id) {
        userService.updateUser(id, inputDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") Integer id) {
        userService.deleteUser(id);
    }
}
