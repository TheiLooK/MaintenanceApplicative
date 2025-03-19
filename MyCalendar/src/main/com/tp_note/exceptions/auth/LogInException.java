package com.tp_note.exceptions.auth;

public abstract class LogInException extends Exception {
    protected LogInException(String message) {
        super(message);
    }
}
