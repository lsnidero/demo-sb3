package com.example.demo.controller;

import com.example.demo.commons.Values;
import com.example.demo.controller.model.MockErrorDemoUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ErrorDemoController {

    @PostMapping(value = "/errordemo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<MockErrorDemoUser> errorDemo(@RequestBody MockErrorDemoUser mockErrorDemoUser) {
        log.info("Hit errorDemo");
        mockErrorDemoUser.add(Link.of(Values.BASE_URL + "/errordemo"));
        return new ResponseEntity<>(mockErrorDemoUser, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}