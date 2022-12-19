package com.quarkbyte.recoveryappjava.model.Case;

import com.quarkbyte.recoveryappjava.model.enums.csj.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public abstract class CaseCSJ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    @Enumerated(EnumType.STRING)
    private StepCSJ stepCSJ;
    private Date resolutionDate;
    private Double value;
    private Double coverageValue;
    @Enumerated(EnumType.STRING)
    private ResolutionType resolutionType;
    private Boolean recidivistCustomer;
    @Enumerated(EnumType.STRING)
    private InternalStatus internalStatus;
    @Enumerated(EnumType.STRING)
    private ExternalStatus externalStatus;

}
