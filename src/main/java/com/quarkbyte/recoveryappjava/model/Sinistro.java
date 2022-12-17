package com.quarkbyte.recoveryappjava.model;

import com.quarkbyte.recoveryapp_api.model.enums.csjSINISTRO.SinistroType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
public class Sinistro extends CaseCSJ{
    public LocalDateTime initalTime;
    public SinistroType type;
    public Boolean imeiStatus;
    public LocalDateTime sinistroDate;
    public Float franchise;
    public Double franchiseTotalValue;
}
