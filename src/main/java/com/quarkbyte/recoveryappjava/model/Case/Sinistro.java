package com.quarkbyte.recoveryappjava.model.Case;

import com.quarkbyte.recoveryappjava.model.enums.csj.*;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Sinistro extends CaseCSJ {
    private Date initalTime;
    private SinistroType type;
    private Boolean imeiStatus;
    private Boolean boStatus;
    private Boolean videoStatus;
    private Date sinistroDate;
    private Float franchise;
    private Double franchiseTotalValue;
    private Double descontValue;
    private Double coverageValue;
    private Boolean payment;

    public Sinistro(Long id, Date date, StepCSJ stepCSJ, Date resolutionDate, Double value,
                    Double coverageValue, ResolutionType resolutionType, Boolean recidivistCustomer,
                    InternalStatus internalStatus, ExternalStatus externalStatus, Date initalTime,
                    SinistroType type, Boolean imeiStatus, Boolean boStatus, Boolean videoStatus, Date sinistroDate,
                    Float franchise, Double franchiseTotalValue, Double descontValue, Double coverageValue1, Boolean payment) {
        super(id, date, stepCSJ, resolutionDate, value, coverageValue, resolutionType, recidivistCustomer,
                internalStatus, externalStatus);
        this.initalTime = initalTime;
        this.type = type;
        this.imeiStatus = imeiStatus;
        this.boStatus = boStatus;
        this.videoStatus = videoStatus;
        this.sinistroDate = sinistroDate;
        this.franchise = franchise;
        this.franchiseTotalValue = franchiseTotalValue;
        this.descontValue = descontValue;
        this.coverageValue = coverageValue1;
        this.payment = payment;
    }

}
