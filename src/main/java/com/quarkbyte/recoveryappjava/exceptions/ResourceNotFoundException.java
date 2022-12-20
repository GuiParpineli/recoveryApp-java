package com.quarkbyte.recoveryappjava.exceptions;

import org.springframework.stereotype.Component;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
