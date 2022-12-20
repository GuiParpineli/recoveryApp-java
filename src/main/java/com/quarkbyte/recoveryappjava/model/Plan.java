package com.quarkbyte.recoveryappjava.model;

import com.quarkbyte.recoveryappjava.model.Case.CaseCSJ;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Double value;
    private Boolean planStatus;
    @ManyToOne
    @JoinColumn(name = "analist_id")
    private User analist;
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
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "bondsman_id")
    private Bondsman bondsman;
    @ManyToOne
    @JoinColumn(name = "caseCSJ_id")
    private CaseCSJ caseCSJ;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private String createDate = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm:ss"));

}
