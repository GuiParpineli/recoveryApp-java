package com.quarkbyte.recoveryappjava.model.Case;

import com.quarkbyte.recoveryappjava.model.enums.csj.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public abstract class CaseCSJ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private  Date date ;
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
