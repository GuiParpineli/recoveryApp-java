package com.quarkbyte.recoveryappjava.model;

import com.quarkbyte.recoveryappjava.model.enums.csj.ExternalStatus;
import com.quarkbyte.recoveryappjava.model.enums.csj.InternalStatus;
import com.quarkbyte.recoveryappjava.model.enums.csj.ResolutionType;
import com.quarkbyte.recoveryappjava.model.enums.csj.StepCSJ;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
abstract class CaseCSJ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
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
