package com.quarkbyte.recoveryappjava.repository;

import com.quarkbyte.recoveryappjava.model.Bondsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BondsmanRepository extends JpaRepository<UUID, Bondsman> { }
