package com.quarkbyte.recoveryappjava.controller;

import com.quarkbyte.recoveryappjava.exceptions.ResourceNotFoundException;
import com.quarkbyte.recoveryappjava.exceptions.SaveErrorException;
import com.quarkbyte.recoveryappjava.model.Address;
import com.quarkbyte.recoveryappjava.service.AddressService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "address", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return service.get();
    }

    @GetMapping
    public ResponseEntity<?> getById(@RequestParam UUID id) throws ResourceNotFoundException {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Address address) throws SaveErrorException {
        return service.save(address);
    }

    @PatchMapping
    public ResponseEntity<?> update(@RequestBody Address address) throws SaveErrorException {
        return service.update(address);
    }

}
