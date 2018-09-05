package main.java.leonid_shop.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private final Long id;
    private final String firstName;
    private final String lastName;
}
