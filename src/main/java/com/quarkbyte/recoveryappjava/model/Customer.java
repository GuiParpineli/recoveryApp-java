package com.quarkbyte.recoveryappjava.model;

import com.quarkbyte.recoveryappjava.model.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private Date date;
    private Date birthDay;
    private Gender gender;
    private String nacionality;

}
