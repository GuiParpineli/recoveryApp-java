package com.quarkbyte.recoveryappjava.service;

import com.quarkbyte.recoveryappjava.repository.BondsmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BondsmanService {
    private final BondsmanRepository repository;

    @Autowired
    public BondsmanService(BondsmanRepository repository) {
        this.repository = repository;
    }
}
