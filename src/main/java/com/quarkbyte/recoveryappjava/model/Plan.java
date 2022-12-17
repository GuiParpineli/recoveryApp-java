package com.quarkbyte.recoveryappjava.model;

import com.quarkbyte.recoveryappjava.model.enums.PlanStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private Double value;
    @Enumerated(EnumType.STRING)
    private PlanStatus planStatus;
    private LocalDateTime initialDate;
    private LocalDateTime finalDate;
    @ManyToMany
    @JoinTable(
            name = "plan_products",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_products")
    )
    private List<Product> productList;
    @ManyToOne
    @JoinColumn(name= "id_bondsman")
    private Bondsman bondsman;
    @ManyToOne
    @JoinColumn(name="id_customer")
    private CaseCSJ caseCSJ;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private String createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm:ss"));


}
