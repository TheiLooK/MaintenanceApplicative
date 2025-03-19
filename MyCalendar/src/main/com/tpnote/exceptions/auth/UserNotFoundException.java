package com.tpnote.exceptions.auth;

import com.tpnote.exceptions.AuthException;

public class UserNotFoundException extends AuthException {
    public UserNotFoundException() {
        super("User not found");
    }
}
