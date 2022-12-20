package com.quarkbyte.recoveryappjava.service;

import com.quarkbyte.recoveryappjava.exceptions.ResourceNotFoundException;
import com.quarkbyte.recoveryappjava.exceptions.SaveErrorException;
import com.quarkbyte.recoveryappjava.model.Plan;
import com.quarkbyte.recoveryappjava.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlanService {

    private final PlanRepository repository;

    @Autowired
    public PlanService(PlanRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> get() {
        List<Plan> saved = repository.findAll();
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> getById(UUID id) throws ResourceNotFoundException {
        Plan saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None  plans founded"));
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> save(Plan customer) throws SaveErrorException {
        Plan saved;
        try {
            saved = repository.save(customer);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> update(Plan customer) throws SaveErrorException {
        Plan saved;
        try {
            saved = repository.saveAndFlush(customer);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> delete(UUID id) throws ResourceNotFoundException {
        Plan saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None plans founded"));
        repository.deleteById(saved.getId());
        return ResponseEntity.ok(saved + " deleted sucessfully");
    }
}
