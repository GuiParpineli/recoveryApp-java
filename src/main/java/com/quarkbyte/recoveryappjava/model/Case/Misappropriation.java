package com.quarkbyte.recoveryappjava.model.Case;

import com.quarkbyte.recoveryappjava.model.enums.csj.PayMethod;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Misappropriation extends CaseCSJ{
    private PayMethod payMethod;
    private Boolean chargeBack;
    private LocalDateTime chargeBackDate;
}
