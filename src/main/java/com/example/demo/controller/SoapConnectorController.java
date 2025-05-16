package com.example.demo.controller;

import com.example.demo.commons.Values;
import com.example.demo.controller.model.MockAnagrafica;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/soap")
public class SoapConnectorController {

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

}