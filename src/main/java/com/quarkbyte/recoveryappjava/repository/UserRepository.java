package com.quarkbyte.recoveryappjava.repository;

import com.quarkbyte.recoveryappjava.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserApp,Long> {
}
