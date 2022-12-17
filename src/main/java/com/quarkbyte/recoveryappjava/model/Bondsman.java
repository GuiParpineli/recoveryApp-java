package com.quarkbyte.recoveryappjava.model;

import com.quarkbyte.recoveryappjava.model.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bondsman {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private UUID id;
   private String name;
   private String lastName;
   private String cpf;
   private String phone;
   @ManyToOne
   private Address address;
   private String email;
   private String birthDay;
   @Enumerated(EnumType.STRING)
   private Gender gender;
}
