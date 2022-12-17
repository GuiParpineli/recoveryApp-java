package com.quarkbyte.recoveryappjava.model.Case;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TechnicalSupport extends CaseCSJ {
    private Double repairValue;
    private Boolean status;
}
