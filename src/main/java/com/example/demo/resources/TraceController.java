package com.example.demo.resources;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TraceController {

    @GetMapping("/trace/test")
    public String testGet() {
        log.info("Hit testGet");
        return "OK";
    }
}
