package com.example.demo.controller;

import com.example.demo.service.MongoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/mongoBson")
public class MongoBsonController {

    private final MongoService mongoService;

    public MongoBsonController(@Autowired MongoService mongoService) {
        this.mongoService = mongoService;
    }

    @GetMapping(value = "/count", produces = MediaTypes.HAL_JSON_VALUE)
    public long count(){
        log.info("Hit count");
        return mongoService.countAll();
    }

    @GetMapping(value = "/find/{documentID1}", produces = MediaTypes.HAL_JSON_VALUE)
    public void b(){

    }
}
