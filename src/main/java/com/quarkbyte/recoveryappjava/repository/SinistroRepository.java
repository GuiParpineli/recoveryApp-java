package com.quarkbyte.recoveryappjava.repository;

import com.quarkbyte.recoveryappjava.model.Case.CaseCSJ;
import com.quarkbyte.recoveryappjava.model.Case.Sinistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SinistroRepository extends JpaRepository<Sinistro, Long> {
}
