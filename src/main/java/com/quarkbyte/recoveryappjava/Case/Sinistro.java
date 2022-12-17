package com.quarkbyte.recoveryappjava.Case;

import com.quarkbyte.recoveryappjava.model.enums.csjSINISTRO.SinistroType;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sinistro extends CaseCSJ {
    @NotNull
    private LocalDateTime initalTime;
    @NotNull
    private SinistroType type;
    @NotNull
    private Boolean imeiStatus;
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
}
