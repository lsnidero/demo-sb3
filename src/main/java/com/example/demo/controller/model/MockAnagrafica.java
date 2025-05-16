package com.example.demo.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MockAnagrafica extends RepresentationModel<MockAnagrafica> {

    private String retCode;
    private String retDesc;
    private List<String> acronyms;


}
