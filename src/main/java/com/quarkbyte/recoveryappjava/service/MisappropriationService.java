package com.quarkbyte.recoveryappjava.service;

import com.quarkbyte.recoveryappjava.exceptions.ResourceNotFoundException;
import com.quarkbyte.recoveryappjava.exceptions.SaveErrorException;
import com.quarkbyte.recoveryappjava.model.Case.Misappropriation;
import com.quarkbyte.recoveryappjava.repository.MisappropriationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MisappropriationService {
    private final MisappropriationRepository repository;

    @Autowired
    public MisappropriationService(MisappropriationRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> get() {
        List<Misappropriation> saved = repository.findAll();
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> getById(UUID id) throws ResourceNotFoundException {
        Misappropriation saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None cases founded"));
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> save(Misappropriation misappropriation) throws SaveErrorException {
        Misappropriation saved;
        try {
            saved = repository.save(misappropriation);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> update(Misappropriation misappropriation) throws SaveErrorException {
        Misappropriation saved;
        try {
            saved = repository.saveAndFlush(misappropriation);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> delete(UUID id) throws ResourceNotFoundException {
        Misappropriation saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None cases founded"));
        repository.deleteById(saved.getId());
        return ResponseEntity.ok(saved + " deleted sucessfully");
    }

}
