package com.tp_note.entities.concrete_actions.auth;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.LoginMenuActionList;
import com.tp_note.entities.concrete_actions.menus.ManageEventMenuActionList;
import com.tp_note.exceptions.auth.LogInException;
import com.tp_note.exceptions.auth.log_in.IncorrectPasswordException;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

public class LoginAction extends Action {
    private static LoginAction instance;

    private LoginAction() {
        super("Se connecter");
    }

    public static LoginAction getInstance() {
        if (instance == null) {
            instance = new LoginAction();
        }
        return instance;
    }

    @Override
    public void perform() {
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
            authService.logIn(login, password);
            displayService.printTexte("Vous êtes connecté");
        } catch (IncorrectPasswordException e) {
            displayService.printTexte("Mot de passe incorrect");
            LoginMenuActionList.getInstance().perform();
            return;
        } catch (LogInException e) {
            displayService.printTexte("Login incorrect");
            LoginMenuActionList.getInstance().perform();
            return;
        }
        ManageEventMenuActionList.getInstance().perform();
    }
}
