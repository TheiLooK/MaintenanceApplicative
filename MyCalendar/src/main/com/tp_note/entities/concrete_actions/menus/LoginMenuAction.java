package com.tp_note.entities.concrete_actions.menus;

import com.tp_note.entities.lists.ListAction;
import com.tp_note.entities.concrete_actions.ExitAction;
import com.tp_note.entities.concrete_actions.auth.LoginAction;
import com.tp_note.entities.concrete_actions.auth.RegisterAction;

import java.util.ArrayList;
import java.util.List;

public class LoginMenuAction extends ListAction {
    private static LoginMenuAction instance;

    private LoginMenuAction() {
        super("Bienvenue dans Calendar Manager. Veuillez vous connecter", new ArrayList<>(List.of(
                LoginAction.getInstance(),
                RegisterAction.getInstance(),
                new ExitAction()
        )));
    }

    public static LoginMenuAction getInstance() {
        if (instance == null) {
            instance = new LoginMenuAction();
        }
        return instance;
    }
}
