package com.tp_note.entities.concrete_actions.auth;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.LoginMenuAction;
import com.tp_note.entities.concrete_actions.menus.ManageEventMenuAction;
import com.tp_note.exceptions.auth.LogInException;
import com.tp_note.exceptions.auth.log_in.IncorrectPasswordException;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

public class LoginAction extends Action {
    public LoginAction() {
        super("Se connecter");
    }


    @Override
    public void DO() {
        AuthService authService = AuthService.getInstance();
        DisplayService displayService = DisplayService.getInstance();

        // Demander à l'utilisateur de rentrer son login et son mot de passe
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

        try {
            authService.login(login, password);
            displayService.printTexte("Vous êtes connecté");
        } catch (IncorrectPasswordException e) {
            displayService.printTexte("Mot de passe incorrect");
            new LoginMenuAction().DO();
            return;
        } catch (LogInException e) {
            displayService.printTexte("Login incorrect");
            new LoginMenuAction().DO();
            return;
        }
        new ManageEventMenuAction().DO();
    }
}
