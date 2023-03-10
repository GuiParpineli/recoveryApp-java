package com.quarkbyte.recoveryappjava.service;

import com.quarkbyte.recoveryappjava.exceptions.ResourceNotFoundException;
import com.quarkbyte.recoveryappjava.exceptions.SaveErrorException;
import com.quarkbyte.recoveryappjava.model.Customer;
import com.quarkbyte.recoveryappjava.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> get() {
        List<Customer> saved = repository.findAll();
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> getById(UUID id) throws ResourceNotFoundException {
        Customer saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None address founded"));
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> save(Customer customer) throws SaveErrorException {
        Customer saved;
        try {
            saved = repository.save(customer);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> update(Customer customer) throws SaveErrorException {
        Customer saved;
        try {
            saved = repository.saveAndFlush(customer);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> delete(UUID id) throws ResourceNotFoundException {
        Customer saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None address founded"));
        repository.deleteById(saved.getId());
        return ResponseEntity.ok(saved + " deleted sucessfully");
    }

}
