package com.tp_note.services;

import com.tp_note.entities.Auth;
import com.tp_note.entities.primitives.Password;
import com.tp_note.entities.primitives.User;
import com.tp_note.exceptions.auth.LogInException;
import com.tp_note.exceptions.auth.log_in.IncorrectPasswordException;
import com.tp_note.exceptions.auth.log_in.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private final List<Auth> auths;
    private User loggedUser;

    private static AuthService instance;

    private AuthService() {
        this.auths = new ArrayList<>();
        this.loggedUser = null;
    }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    public void logIn(String username, String password) throws LogInException {
        Auth getUser = auths.stream().filter(auth -> auth.username.name().equals(username)).findFirst().orElse(null);

        if (getUser == null) {
            throw new UserNotFoundException();
        }

        if (!getUser.password.checkPassword(password)) {
            throw new IncorrectPasswordException();
        }

        loggedUser = getUser.username;
    }

    public void register(String user, String password) {
        auths.add(new Auth(new User(user), new Password(password)));
    }

    public void logOut() {
        loggedUser = null;
    }

    public boolean isRegistered(String username) {
        return auths.stream().anyMatch(auth -> auth.username.name().equals(username));
    }

    public User getLoggedUser() {
        return loggedUser;
    }
}
