package com.quarkbyte.recoveryappjava.repository;

import com.quarkbyte.recoveryappjava.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> { }
