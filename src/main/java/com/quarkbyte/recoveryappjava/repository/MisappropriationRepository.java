package com.quarkbyte.recoveryappjava.repository;

import com.quarkbyte.recoveryappjava.model.Case.Misappropriation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MisappropriationRepository extends JpaRepository<Misappropriation, UUID> {
}
