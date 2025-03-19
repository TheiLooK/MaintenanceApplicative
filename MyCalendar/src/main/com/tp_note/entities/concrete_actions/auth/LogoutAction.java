package com.tp_note.entities.concrete_actions.auth;

import com.tp_note.entities.Action;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

public class LogoutAction extends Action {
    public LogoutAction() {
        super("Se déconnecter");
    }


    @Override
    public void DO() {
        AuthService.getInstance().logOut();
        DisplayService.getInstance().printTexte("Vous êtes déconnecté");
        new LoginAction().DO();
    }
}
