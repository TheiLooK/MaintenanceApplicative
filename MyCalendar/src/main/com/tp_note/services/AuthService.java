package com.tp_note.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tp_note.entities.Auth;
import com.tp_note.entities.primitives.Password;
import com.tp_note.entities.primitives.User;
import com.tp_note.exceptions.auth.LogInException;
import com.tp_note.exceptions.auth.log_in.IncorrectPasswordException;
import com.tp_note.exceptions.auth.log_in.UserNotFoundException;
import com.tp_note.exceptions.auth.register.UserAlreadyExistsException;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuthService {
    @Getter
    private final List<Auth> auths;
    @Getter
    private User loggedUser;

    private static AuthService instance;
    private static final String FILE_PATH = "src/ressources/auths.json";
    private final ObjectMapper mapper;

    private AuthService() {
        this.auths = new ArrayList<>();
        this.loggedUser = null;
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        loadAuthsFromFile();
    }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    private void loadAuthsFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                Auth[] authArray = mapper.readValue(file, Auth[].class);
                Collections.addAll(auths, authArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAuthsToFile() {
        try {
            mapper.writeValue(new File(FILE_PATH), auths);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void register(String user, String password) throws UserAlreadyExistsException {
        if (isRegistered(user)) {
            throw new UserAlreadyExistsException();
        }
        auths.add(new Auth(new User(user), new Password(password)));
        saveAuthsToFile();
    }

    public void logOut() {
        loggedUser = null;
    }

    public boolean isRegistered(String username) {
        return auths.stream().anyMatch(auth -> auth.username.name().equals(username));
    }
}