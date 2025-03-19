package com.tpnote.entities;

import com.tpnote.entities.primitives.Password;
import com.tpnote.entities.primitives.User;

public class Auth {
    public User username;
    public Password password;

    public Auth(User username, Password password) {
        this.username = username;
        this.password = password;
    }
}
