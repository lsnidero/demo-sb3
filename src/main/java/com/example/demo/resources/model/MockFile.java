package com.example.demo.resources.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MockFile extends RepresentationModel<MockFile> {

    private String nameFile; //":"newFile1"}
}
