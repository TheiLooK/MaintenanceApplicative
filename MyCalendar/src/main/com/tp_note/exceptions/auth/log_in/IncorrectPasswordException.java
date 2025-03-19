package com.tp_note.exceptions.auth.log_in;

import com.tp_note.exceptions.auth.LogInException;

public class IncorrectPasswordException extends LogInException {
    public IncorrectPasswordException() {
        super("Incorrect password");
    }
}
