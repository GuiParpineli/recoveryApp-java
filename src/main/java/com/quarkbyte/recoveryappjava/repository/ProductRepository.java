package com.quarkbyte.recoveryappjava.repository;

import com.quarkbyte.recoveryappjava.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> { }
