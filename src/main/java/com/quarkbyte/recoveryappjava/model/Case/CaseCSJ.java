package com.quarkbyte.recoveryappjava.model.Case;

import com.quarkbyte.recoveryappjava.model.enums.csj.ExternalStatus;
import com.quarkbyte.recoveryappjava.model.enums.csj.InternalStatus;
import com.quarkbyte.recoveryappjava.model.enums.csj.ResolutionType;
import com.quarkbyte.recoveryappjava.model.enums.csj.StepCSJ;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public abstract class CaseCSJ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    @Enumerated(EnumType.STRING)
    private StepCSJ stepCSJ;
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

}
