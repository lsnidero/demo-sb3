package com.example.demo.resources.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MockErrorDemoUser extends RepresentationModel<MockErrorDemoUser> {

    private String id;
    private String username;
    private String firstName;
    private String surname;

    public static MockErrorDemoUser defaultMockUser() {

        return new MockErrorDemoUser("12345", "username1", "Name", "Surname");
    }

}
