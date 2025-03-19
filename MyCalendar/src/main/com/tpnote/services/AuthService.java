package com.tpnote.services;

import com.tpnote.entities.Auth;
import com.tpnote.entities.primitives.User;
import com.tpnote.exceptions.AuthException;
import com.tpnote.exceptions.auth.IncorrectPasswordException;
import com.tpnote.exceptions.auth.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AuthService {
    public List<Auth> auths;

    private static AuthService instance;

    private AuthService() {
        this.auths = new ArrayList<>();
    }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    public User login(String username, String password) throws AuthException {
        Auth getUser = auths.stream().filter(auth -> auth.username.name().equals(username)).findFirst().orElse(null);

        if (getUser == null) {
            throw new UserNotFoundException();
        }

        if (!getUser.password.checkPassword(password)) {
            throw new IncorrectPasswordException();
        }

        return getUser.username;
    }
}
