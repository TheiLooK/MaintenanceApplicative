package com.tpnote.exceptions;

public abstract class AuthException extends Exception {
    protected AuthException(String message) {
        super(message);
    }
}
