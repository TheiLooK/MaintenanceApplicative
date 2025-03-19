package com.tp_note.exceptions.auth.log_in;

import com.tp_note.exceptions.auth.LogInException;

public class UserNotFoundException extends LogInException {
    public UserNotFoundException() {
        super("User not found");
    }
}
