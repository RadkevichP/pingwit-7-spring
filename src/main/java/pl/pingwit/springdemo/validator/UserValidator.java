package pl.pingwit.springdemo.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import pl.pingwit.springdemo.controller.CreateUserInputDto;
import pl.pingwit.springdemo.exception.PingwitValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


@Component
public class UserValidator {

    public static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
    private static final Pattern ONLY_LETTERS_PATTERN = Pattern.compile("^[a-zA-Z]*$");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\d+");

    public void validateOnCreate(CreateUserInputDto input) {
        // имя - это не пустая строка
        // фамилия - не пустая строка
        // имэйл - валидная строка

        // имэйлов таких в ситеме нет

        // в телефоне содрежатся только цифры
        List<String> errors = new ArrayList<>();

        if (StringUtils.isBlank(input.getName())) {
            errors.add("Name is blank");
        }
        if (StringUtils.isBlank(input.getSurname())) {
            errors.add("Surname is blank");
        }
        if (!EMAIL_PATTERN.matcher(input.getEmail()).matches()) {
            errors.add("Email is invalid: " + input.getEmail());
        }
        if (!PHONE_NUMBER_PATTERN.matcher(input.getPhone()).matches()) {
            errors.add("Phone can contain only numbers: " + input.getPhone());
        }
        // достать все имэйлы, пробежаться по ним в и проверить, нет ли такого
        // достать, сложить в сет и проверить через метод contains(email)
        // написать в репозитории метод List<User> findAllByEmail(String email)


        if (!errors.isEmpty()) {
            throw new PingwitValidationException("User data is invalid: ", errors);
        }
    }





















   /* public void validateUser(UserDTO userDTO) {

        List<String> violations = new ArrayList<>();

        validateLetterField(userDTO.getName(), "name", violations);
        validateLetterField(userDTO.getSurname(), "surname", violations);
        validatePhone(userDTO, violations);
        validateEmail(userDTO, violations);

        if (!violations.isEmpty()) {
            throw new ValidationException("Provided user is invalid!" , violations);
        }

    }

    private void validateEmail(UserDTO userDTO, List<String> violations) {
        if (!EMAIL_PATTERN.matcher(userDTO.getEmail()).matches()) {
            violations.add(String.format("invalid email: %s", userDTO.getEmail()));
        }
    }

    private void validatePhone(UserDTO userDTO, List<String> violations) {
        if (!PHONE_NUMBER_PATTERN.matcher(userDTO.getPhone()).matches()) {
            violations.add(String.format("'%s' with value '%s' can contain only digits", "phone", userDTO.getPhone()));
        }
    }

    private void validateLetterField(String value, String fieldName, List<String> violations) {
        if (isBlank(value)) {
            violations.add("Name is blank");
        }
        if (!ONLY_LETTERS_PATTERN.matcher(value).matches()) {
            violations.add(String.format("%s can contain only letters: %s", fieldName, value));
        }
    }

*/
}

