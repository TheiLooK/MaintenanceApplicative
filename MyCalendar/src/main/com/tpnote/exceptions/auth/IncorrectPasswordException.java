package com.tpnote.exceptions.auth;

import com.tpnote.exceptions.AuthException;

public class IncorrectPasswordException extends AuthException {
    public IncorrectPasswordException() {
        super("Incorrect password");
    }
}
