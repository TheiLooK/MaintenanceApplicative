package com.tp_note.entities.concrete_actions.auth;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.LoginMenuActionList;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

public class LogoutAction extends Action {
    private static LogoutAction instance;

    private LogoutAction() {
        super("Se déconnecter");
    }

    public static LogoutAction getInstance() {
        if (instance == null) {
            instance = new LogoutAction();
        }
        return instance;
    }

    @Override
    public void perform() {
        AuthService.getInstance().logOut();
        DisplayService.getInstance().printTexte("Vous êtes déconnecté");
        LoginMenuActionList.getInstance().perform();
    }
}
