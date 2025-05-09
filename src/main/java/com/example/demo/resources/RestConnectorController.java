package com.example.demo.resources;

import com.example.demo.commons.Values;
import com.example.demo.resources.model.MockAnagrafica;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest")
public class RestConnectorController {

    @GetMapping(value = "/getAnagrafica", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<MockAnagrafica> getAnagrafica(@RequestParam(required = false) String flagAnagraficaFunzione,
                                                        @RequestParam(required = false) String flagAnagraficaUtente,
                                                        @RequestParam(required = false) String siteName,
                                                        @RequestParam(required = false) String userId) {
        log.info("Hit getAnagrafica");
        MockAnagrafica mockAnagrafica = new MockAnagrafica("000", "Estrazione avvenuta con successo", null);
        mockAnagrafica.add(Link.of(Values.BASE_URL + "/getAnagrafica"));
        return new ResponseEntity<>(mockAnagrafica, HttpStatus.OK);
    }


    @GetMapping(value = "/getAcronyms", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<MockAnagrafica> getAcronyms() {
        log.info("Hit getAcronyms");

        MockAnagrafica mockAnagrafica = new MockAnagrafica("000", "Estrazione avvenuta con successo", List.of(
                "3EZB0",
                "BEAR0",
                "LOCA0",
                "DARW0",
                "PUHA0"));
        mockAnagrafica.add(Link.of(Values.BASE_URL + "/getAcronyms"));
        return new ResponseEntity<>(mockAnagrafica, HttpStatus.OK);
    }


}