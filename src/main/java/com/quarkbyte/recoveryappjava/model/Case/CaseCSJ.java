package com.quarkbyte.recoveryappjava.model.Case;

import com.quarkbyte.recoveryappjava.model.enums.csj.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
public abstract class CaseCSJ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    @Enumerated(EnumType.STRING)
    private StepCSJ stepCSJ;
    @Enumerated(EnumType.STRING)
    private TypeCSJ type;
    private LocalDateTime resolutionDate;
    private Double value;
    private Double covarageValue;
    @Enumerated(EnumType.STRING)
    private ResolutionType resolutionType;
    private Boolean recidivistCustomer;
    @Enumerated(EnumType.STRING)
    private InternalStatus internalStatus;
    @Enumerated(EnumType.STRING)
    private ExternalStatus externalStatus;

    public CaseCSJ(Long id, String date, StepCSJ stepCSJ, TypeCSJ type, LocalDateTime resolutionDate, Double value, Double covarageValue, ResolutionType resolutionType, Boolean recidivistCustomer, InternalStatus internalStatus, ExternalStatus externalStatus) {
        this.id = id;
        this.date = date;
        this.stepCSJ = stepCSJ;
        this.type = type;
        this.resolutionDate = resolutionDate;
        this.value = value;
        this.covarageValue = covarageValue;
        this.resolutionType = resolutionType;
        this.recidivistCustomer = recidivistCustomer;
        this.internalStatus = internalStatus;
        this.externalStatus = externalStatus;
    }

    public CaseCSJ() {

    }
}
