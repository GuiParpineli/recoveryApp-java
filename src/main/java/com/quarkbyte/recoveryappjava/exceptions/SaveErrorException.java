package com.quarkbyte.recoveryappjava.exceptions;

import org.springframework.stereotype.Component;

public class SaveErrorException extends Exception {
    public SaveErrorException(String message) {
        super(message);
    }
}
