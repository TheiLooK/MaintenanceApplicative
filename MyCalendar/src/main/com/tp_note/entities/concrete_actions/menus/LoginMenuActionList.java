package com.tp_note.entities.concrete_actions.menus;

import com.tp_note.entities.lists.ActionList;
import com.tp_note.entities.concrete_actions.ExitAction;
import com.tp_note.entities.concrete_actions.auth.LoginAction;
import com.tp_note.entities.concrete_actions.auth.RegisterAction;

import java.util.ArrayList;
import java.util.List;

public class LoginMenuActionList extends ActionList {
    private static LoginMenuActionList instance;

    private LoginMenuActionList() {
        super("Bienvenue dans Calendar Manager. Veuillez vous connecter", new ArrayList<>(List.of(
                LoginAction.getInstance(),
                RegisterAction.getInstance(),
                new ExitAction()
        )));
    }

    public static LoginMenuActionList getInstance() {
        if (instance == null) {
            instance = new LoginMenuActionList();
        }
        return instance;
    }
}
