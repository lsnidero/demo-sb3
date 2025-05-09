package com.example.demo.resources;

import com.example.demo.commons.Values;
import com.example.demo.resources.model.MockCache;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/managed-cache")
public class ManagedCacheResource {



    @PostMapping(value = "/put", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<String> put(@RequestBody(required = false) MockCache mockCache) {
        log.info("Hit put");

        return new ResponseEntity<>("42", HttpStatus.OK);
    }

    @GetMapping(value = "/get/{keyGenerated}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<MockCache> get(@PathVariable String keyGenerated) {
        log.info("Hit pull {}", keyGenerated);
        MockCache mockCache = new MockCache(keyGenerated);
        mockCache.add(Link.of(Values.BASE_URL + "/hazelcast/pull/42"));
        return new ResponseEntity<>(mockCache, HttpStatus.OK);
    }

    @PatchMapping(value = "/replace/{keyGenerated}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<String> update(@PathVariable String keyGenerated) {
        log.info("Hit update {}", keyGenerated);
        return new ResponseEntity<>("42", HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove/{keyGenerated}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<String> remove(@PathVariable String keyGenerated) {
        log.info("Hit delete {}", keyGenerated);
        return new ResponseEntity<>("42", HttpStatus.OK);
    }
}
