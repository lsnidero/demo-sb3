package com.example.demo.resources;

import com.example.demo.resources.model.MockFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StorageController {
    /// storage?key=newFile1&fileType=application/json

    @PostMapping(value = "/storage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<MockFile> uploadFile(@RequestParam String key, @RequestParam String fileType) {
        log.info("Hit uploadFile");
        return new ResponseEntity<>(new MockFile(key), HttpStatus.OK);
    }

    @GetMapping(value = "/storage/newFile1",consumes =MediaTypes.HAL_JSON_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public String getFile() {
        log.info("Hit getFile");

        return "{\"json\": \"someValue\"}";
    }


    @PostMapping(value = "/storage/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<MockFile> updateFile(@RequestParam String key, @RequestParam String fileType) {
        log.info("Hit updateFile");
        return new ResponseEntity<>(new MockFile(key), HttpStatus.OK);
    }

    @GetMapping(value = "/storage/no-stream/newFile1",consumes =MediaTypes.HAL_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public String getFileNoStream() {
        log.info("Hit getFileNoStream");
        return "{\"nameFile\":\"newFile1\"},{\"value\":\"someValue1\"}";
    }

    @DeleteMapping(value = "/storage/newFile1",consumes =MediaTypes.HAL_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<MockFile> deleteFile() {
        log.info("Hit deleteFile");
        return new ResponseEntity<>(new MockFile("newFile1"), HttpStatus.OK);
    }

    public void fileNotFound() {

    }
}
