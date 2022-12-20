package com.quarkbyte.recoveryappjava.service;

import com.quarkbyte.recoveryappjava.exceptions.ResourceNotFoundException;
import com.quarkbyte.recoveryappjava.exceptions.SaveErrorException;
import com.quarkbyte.recoveryappjava.model.Product;
import com.quarkbyte.recoveryappjava.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository repository;


    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> get() {
        List<Product> saved = repository.findAll();
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> getById(UUID id) throws ResourceNotFoundException {
        Product saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None products founded"));
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> save(Product customer) throws SaveErrorException {
        Product saved;
        try {
            saved = repository.save(customer);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> update(Product customer) throws SaveErrorException {
        Product saved;
        try {
            saved = repository.saveAndFlush(customer);
        } catch (Exception e) {
            throw new SaveErrorException("Error, not saved");
        }
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<?> delete(UUID id) throws ResourceNotFoundException {
        Product saved = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("None products founded"));
        repository.deleteById(saved.getId());
        return ResponseEntity.ok(saved + " deleted sucessfully");
    }

}
