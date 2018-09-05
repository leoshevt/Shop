package main.java.leonid_shop.domain.user.service;

import leonid_shop.domain.user.dto.User;
import leonid_shop.domain.user.repository.UserRepository;
import leonid_shop.domain.user.repository.entity.UserEntity;
import leonid_shop.infra.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(User user) {
        final UserEntity entity = UserEntity.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
        return userRepository.save(entity).toDto();
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public User getUser(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(UserEntity.class))
                .toDto();
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(UserEntity::toDto)
                .collect(toList());
    }
}
