package com.example.demo.resources.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MockUser extends RepresentationModel<MockUser> {
    private String age;
    private String email;
    private UUID id;

    public static MockUser defaultUser() {
        return new MockUser("52", "pluto@mail.com", UUID.fromString("feaa864c-0932-4855-a06d-ac6ee767e596"));
    }
}
