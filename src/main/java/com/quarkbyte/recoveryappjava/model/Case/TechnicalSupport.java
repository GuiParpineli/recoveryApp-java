package com.quarkbyte.recoveryappjava.model.Case;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TechnicalSupport extends CaseCSJ {
    private Double repairValue;
    private Boolean status;
}
