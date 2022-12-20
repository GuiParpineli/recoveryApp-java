package com.quarkbyte.recoveryappjava.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDTO {
    public String name;
    public String lastName;
    public String email;
}
