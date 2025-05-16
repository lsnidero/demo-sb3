package com.example.demo.resources;

import com.example.demo.resources.model.MockUser;
import com.example.demo.service.UsersJdbcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/jdbc")
public class JdbcController {

    private final UsersJdbcService usersJdbcService;

    public JdbcController(@Autowired UsersJdbcService usersJdbcService) {
        this.usersJdbcService = usersJdbcService;
    }

    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public HttpEntity<MockUser> createUser(@RequestBody MockUser user) {
        log.info("Hit createUser");
        user.add(Link.of(String.format("http://localhost:9080/jdbc/getUser/%s", user.getId())));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public HttpEntity<MockUser> updateUser(@RequestBody MockUser user) {
        log.info("Hit updateUser");
        user.add(Link.of(String.format("http://localhost:9080/jdbc/getUser/%s", user.getId())));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/getUser/{userId}", produces = MediaTypes.HAL_JSON_VALUE)
    public HttpEntity<MockUser> getUser(@PathVariable String userId) {
        log.info("Hit getUser {}", userId);
        MockUser user = usersJdbcService.findUserById(userId);
        user.add(Link.of(String.format("http://localhost:9080/jdbc/getUser/%s", user.getId())));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser/{userId}", produces = MediaTypes.HAL_JSON_VALUE)
    public String deleteUser(@PathVariable String userId) {
        log.info("Hit deleteUser {}", userId);
        return "\"OK\"";
    }

}