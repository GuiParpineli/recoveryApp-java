package com.quarkbyte.recoveryappjava.service;

import com.quarkbyte.recoveryappjava.exceptions.ResourceNotFoundException;
import com.quarkbyte.recoveryappjava.exceptions.SaveErrorException;
import com.quarkbyte.recoveryappjava.model.Case.Sinistro;
import com.quarkbyte.recoveryappjava.model.Case.Sinistro;
import com.quarkbyte.recoveryappjava.repository.SinistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SinsitroService {
    private final SinistroRepository repository;

    @Autowired
    public SinsitroService(SinistroRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> get() {
        List<Sinistro> saved = repository.findAll();
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> getById(UUID id) throws ResourceNotFoundException {
        Sinistro saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None cases founded"));
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> save(Sinistro sinistro) throws SaveErrorException {
        Sinistro saved;
        try {
            saved = repository.save(sinistro);
        } catch (Exception e) {
            throw new SaveErrorException("Error not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> update(Sinistro sinistro) throws SaveErrorException {
        Sinistro saved;
        try {
            saved = repository.saveAndFlush(sinistro);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> delete(UUID id) throws ResourceNotFoundException {
        Sinistro saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None cases founded"));
        repository.deleteById(saved.getId());
        return ResponseEntity.ok(saved + " deleted sucessfully");
    }

}
