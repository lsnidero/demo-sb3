package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/gridFS")
public class MongoGridFsController {

    @GetMapping(value = "/{gridFSDocumentId}", produces = MediaTypes.HAL_JSON_VALUE)
    public void a() {

    }


}
