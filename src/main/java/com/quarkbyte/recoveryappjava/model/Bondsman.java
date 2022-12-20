package com.quarkbyte.recoveryappjava.model;

import com.quarkbyte.recoveryappjava.model.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Bondsman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String cpf;
    private String phone;
    @ManyToOne
    private Address address;
    private String email;
    private Date birthDay;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String nationality;
}
