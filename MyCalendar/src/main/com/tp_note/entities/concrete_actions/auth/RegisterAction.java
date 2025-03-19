package com.tp_note.entities.concrete_actions.auth;

import com.tp_note.entities.Action;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

public class RegisterAction extends Action {
    public RegisterAction() {
        super("Register");
    }

    @Override
    public void DO() {
        DisplayService displayService = DisplayService.getInstance();

        String login = displayService.printInputString("Entrez votre nom d'utilisateur : ");
        while (login.length() < 3) {
            displayService.printTexte("Le login doit faire au moins 3 caractères");
            login = displayService.printInputString("Entrez votre nom d'utilisateur : ");
        }

        String password = displayService.printInputString("Entrez votre mot de passe : ");
        while (password.length() < 3) {
            displayService.printTexte("Le mot de passe doit faire au moins 3 caractères");
            password = displayService.printInputString("Entrez votre mot de passe : ");
        }

        AuthService.getInstance().register(login, password);

        displayService.printTexte("Vous êtes inscrit");

        new LoginAction().DO();
    }
}
