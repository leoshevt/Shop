package main.java.leonid_shop.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserCreateRequest {
    private final String firstName;
    private final String lastName;

    @JsonCreator
    public UserCreateRequest(@JsonProperty("firstName") String firstName,
                             @JsonProperty("lastName") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}