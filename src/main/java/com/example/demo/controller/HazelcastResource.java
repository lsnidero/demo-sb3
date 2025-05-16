package com.example.demo.controller;

import com.example.demo.commons.Values;
import com.example.demo.controller.model.MockCache;
import com.example.demo.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/hazelcast")
public class HazelcastResource {

    private final CacheService cacheService;

    public HazelcastResource(@Autowired CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /*
    @PostMapping(value = "/push", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<MockCache> push(@RequestBody(required = false) MockCache mockCache) {
        log.info("Hit push");
        mockCache.setKeyGenerated("42");
        mockCache.add(Link.of(Values.BASE_URL + "/hazelcast/pull/42"));
        return new ResponseEntity<>(mockCache, HttpStatus.OK);
    }

     */

    @PostMapping(value = "/push", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<String> push(@RequestBody(required = false) MockCache mockCache) {
        log.info("Hit push");
        String newKey = cacheService.generateKey();
        return new ResponseEntity<>(newKey, HttpStatus.OK);
    }

    @GetMapping(value = "/pull/{keyGenerated}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<MockCache> pull(@PathVariable String keyGenerated) {
        log.info("Hit pull {}", keyGenerated);
        MockCache mockCache = new MockCache(keyGenerated);
        mockCache.add(Link.of(Values.BASE_URL + "/hazelcast/pull/42"));
        return new ResponseEntity<>(mockCache, HttpStatus.OK);
    }

    @PatchMapping(value = "/update/{keyGenerated}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<String> update(@PathVariable String keyGenerated) {
        log.info("Hit update {}", keyGenerated);
        return new ResponseEntity<>("42", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{keyGenerated}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable String keyGenerated) {
        log.info("Hit delete {}", keyGenerated);
        return new ResponseEntity<>("42", HttpStatus.OK);
    }
}
