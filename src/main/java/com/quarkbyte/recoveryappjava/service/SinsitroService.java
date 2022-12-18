package com.quarkbyte.recoveryappjava.service;

import com.quarkbyte.recoveryappjava.model.Case.Sinistro;
import com.quarkbyte.recoveryappjava.repository.SinistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SinsitroService{
    private final SinistroRepository repository;

    @Autowired
    public SinsitroService(SinistroRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<String> saveSinistro(Sinistro sinistro) {
        repository.save(sinistro);
        return ResponseEntity.ok("saved");
    }

}
