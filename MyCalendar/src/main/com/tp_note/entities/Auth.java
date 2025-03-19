package com.tp_note.entities;

import com.tp_note.entities.primitives.Password;
import com.tp_note.entities.primitives.User;

public class Auth {
    public User username;
    public Password password;

    public Auth(User username, Password password) {
        this.username = username;
        this.password = password;
    }
}
