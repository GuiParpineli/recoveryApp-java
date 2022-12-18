package com.quarkbyte.recoveryappjava.controller;

import com.quarkbyte.recoveryappjava.model.Case.Sinistro;
import com.quarkbyte.recoveryappjava.service.SinsitroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "case", produces = MediaType.APPLICATION_JSON_VALUE)
public class SinistroController{
    private final SinsitroService service;

    @Autowired
    public SinistroController(SinsitroService service) {
        this.service = service;
    }

    @PostMapping("/sinistro")
    public ResponseEntity<?> save(@RequestBody Sinistro sinistro) {
        service.saveSinistro(sinistro);
        return null;
    }
}
