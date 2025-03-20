package com.tp_note.entities.concrete_actions.auth;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.LoginMenuAction;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

public class RegisterAction extends Action {
    private static RegisterAction instance;

    private RegisterAction() {
        super("S'inscrire");
    }

    public static RegisterAction getInstance() {
        if (instance == null) {
            instance = new RegisterAction();
        }
        return instance;
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

        LoginMenuAction.getInstance().DO();
    }
}
