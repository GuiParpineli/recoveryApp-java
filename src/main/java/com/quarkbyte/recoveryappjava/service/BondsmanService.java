package com.quarkbyte.recoveryappjava.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quarkbyte.recoveryappjava.exceptions.ResourceNotFoundException;
import com.quarkbyte.recoveryappjava.exceptions.SaveErrorException;
import com.quarkbyte.recoveryappjava.model.Bondsman;
import com.quarkbyte.recoveryappjava.model.DTO.BondsmanDTO;
import com.quarkbyte.recoveryappjava.repository.BondsmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BondsmanService {
    private final BondsmanRepository repository;
    private final ObjectMapper mapper;

    @Autowired
    public BondsmanService(BondsmanRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ResponseEntity<?> get() throws ResourceNotFoundException {
        List<Bondsman> saved = repository.findAll();
        List<BondsmanDTO> bondsmanDTOS = null;
        if (saved.isEmpty()) throw new ResourceNotFoundException("None Bondsman founded");
        saved.forEach(c -> bondsmanDTOS.add(mapper.convertValue(c, BondsmanDTO.class)));
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> getById(UUID id) throws ResourceNotFoundException {
        Bondsman saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None address founded"));
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> save(Bondsman bondsman) throws SaveErrorException {
        Bondsman saved;
        try {
            saved = repository.save(bondsman);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> update(Bondsman bondsman) throws SaveErrorException {
        Bondsman saved;
        try {
            saved = repository.saveAndFlush(bondsman);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> delete(UUID id) throws ResourceNotFoundException {
        Bondsman saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None address founded"));
        repository.deleteById(saved.getId());
        return ResponseEntity.ok(saved + " deleted successfully");
    }

}
