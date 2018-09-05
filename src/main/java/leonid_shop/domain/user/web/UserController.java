package main.java.leonid_shop.domain.user.web;

import leonid_shop.domain.user.dto.User;
import leonid_shop.domain.user.dto.UserCreateRequest;
import leonid_shop.domain.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.String.format;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    public User saveUser(@RequestBody UserCreateRequest request) {
        final String firstName = request.getFirstName();
        final String lastName = request.getLastName();
        log.info(format("Saving user [firstName=%s, lastName=%s]", firstName, lastName));
        final User build = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
        return userService.saveUser(build);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        log.info(format("Deleting user [id=%d]", id));
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
