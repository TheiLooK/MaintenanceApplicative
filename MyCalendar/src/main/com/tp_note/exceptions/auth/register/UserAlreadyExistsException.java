package com.tp_note.exceptions.auth.register;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException() {
        super("L'utilisateur existe déjà.");
    }
}
