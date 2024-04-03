package pl.pingwit.springdemo.repository.user;

/**
 * @author Pavel Radkevich
 */
public record User(Integer id, String name, String surname, String email, String phone) {
}
