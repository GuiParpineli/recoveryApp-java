package com.quarkbyte.recoveryappjava.service;

import com.quarkbyte.recoveryappjava.exceptions.ResourceNotFoundException;
import com.quarkbyte.recoveryappjava.exceptions.SaveErrorException;
import com.quarkbyte.recoveryappjava.model.Case.TechnicalSupport;
import com.quarkbyte.recoveryappjava.repository.TechnicalSupportRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TechnicalSupportService {
    private final TechnicalSupportRepository repository;

    public TechnicalSupportService(TechnicalSupportRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> get() {
        List<TechnicalSupport> saved = repository.findAll();
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> getById(UUID id) throws ResourceNotFoundException {
        TechnicalSupport saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None cases founded"));
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> save(TechnicalSupport techSupport) throws SaveErrorException {
        TechnicalSupport saved;
        try {
            saved = repository.save(techSupport);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> update(TechnicalSupport techSupport) throws SaveErrorException {
        TechnicalSupport saved;
        try {
            saved = repository.saveAndFlush(techSupport);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> delete(UUID id) throws ResourceNotFoundException {
        TechnicalSupport saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None cases founded"));
        repository.deleteById(saved.getId());
        return ResponseEntity.ok(saved + " deleted sucessfully");
    }

}
