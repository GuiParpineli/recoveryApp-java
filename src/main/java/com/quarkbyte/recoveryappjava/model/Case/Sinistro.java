package com.quarkbyte.recoveryappjava.model.Case;

import com.quarkbyte.recoveryappjava.model.enums.csj.*;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Sinistro extends CaseCSJ {
    @NotNull
    private Date initalTime;
    @NotNull
    private SinistroType type;
    private Boolean imeiStatus;
    private Boolean boStatus;
    private Boolean videoStatus;
    @NotNull
    private Date sinistroDate;
    @NotNull
    private Float franchise;
    @NotNull
    private Double franchiseTotalValue;
    @NotNull
    private Double descontValue;
    @NotNull
    private Double coverageValue;
    private Boolean payment;

}
