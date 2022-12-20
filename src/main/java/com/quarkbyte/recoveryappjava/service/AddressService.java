package com.quarkbyte.recoveryappjava.service;

import com.quarkbyte.recoveryappjava.exceptions.ResourceNotFoundException;
import com.quarkbyte.recoveryappjava.exceptions.SaveErrorException;
import com.quarkbyte.recoveryappjava.model.Address;
import com.quarkbyte.recoveryappjava.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    private final AddressRepository repository;

    @Autowired
    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> get() {
        List<Address> saved = repository.findAll();
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> getById(Long id) throws ResourceNotFoundException {
        Address saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None address founded"));
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> save(Address address) throws SaveErrorException {
        Address saved;
        try {
            saved = repository.save(address);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> update(Address address) throws SaveErrorException {
        Address saved;
        try {
            saved = repository.saveAndFlush(address);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> delete(Long id) throws ResourceNotFoundException {
        Address saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None address founded"));
        repository.deleteById(saved.getId());
        return ResponseEntity.ok("Addres" + saved + " deleted sucessfully");
    }

}
