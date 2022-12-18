package com.quarkbyte.recoveryappjava.model.Case;

import com.quarkbyte.recoveryappjava.model.enums.csj.*;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Sinistro extends CaseCSJ {
    @NotNull
    private LocalDateTime initalTime;
    @NotNull
    private SinistroType type;
    private Boolean imeiStatus;
    private Boolean boStatus;
    private Boolean videoStatus;
    @NotNull
    private LocalDateTime sinistroDate;
    @NotNull
    private Float franchise;
    @NotNull
    private Double franchiseTotalValue;
    @NotNull
    private Double descontValue;
    @NotNull
    private Double coverageValue;
    private Boolean payment;

    public Sinistro(Long id, String date, StepCSJ stepCSJ, TypeCSJ type, LocalDateTime resolutionDate, Double value, Double covarageValue, ResolutionType resolutionType, Boolean recidivistCustomer, InternalStatus internalStatus, ExternalStatus externalStatus, LocalDateTime initalTime, SinistroType type1, Boolean imeiStatus, Boolean boStatus, Boolean videoStatus, LocalDateTime sinistroDate, Float franchise, Double franchiseTotalValue, Double descontValue, Double coverageValue, Boolean payment) {
        super(id, date, stepCSJ, type, resolutionDate, value, covarageValue, resolutionType, recidivistCustomer, internalStatus, externalStatus);
        this.initalTime = initalTime;
        this.type = type1;
        this.imeiStatus = imeiStatus;
        this.boStatus = boStatus;
        this.videoStatus = videoStatus;
        this.sinistroDate = sinistroDate;
        this.franchise = franchise;
        this.franchiseTotalValue = franchiseTotalValue;
        this.descontValue = descontValue;
        this.coverageValue = coverageValue;
        this.payment = payment;
    }

}
