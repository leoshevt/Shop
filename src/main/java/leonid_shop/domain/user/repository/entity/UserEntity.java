package main.java.leonid_shop.domain.user.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import leonid_shop.domain.user.dto.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    public User toDto() {
        return User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
}
