package com.tp_note.entities.concrete_actions.menus;

import com.tp_note.entities.ListAction;
import com.tp_note.entities.concrete_actions.ExitAction;
import com.tp_note.entities.concrete_actions.auth.LoginAction;
import com.tp_note.entities.concrete_actions.auth.RegisterAction;

import java.util.ArrayList;
import java.util.List;

public class LoginMenuAction extends ListAction {
    public LoginMenuAction() {
        super("Bienvenue dans Calendar Manager. Veuillez vous connecter", new ArrayList<>(List.of(
                new LoginAction(),
                new RegisterAction(),
                new ExitAction()
        )));

    }
}
