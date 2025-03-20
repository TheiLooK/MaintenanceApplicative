package com.tp_note.entities.concrete_actions.menus;

import com.tp_note.entities.lists.ActionList;
import com.tp_note.entities.concrete_actions.auth.LogoutAction;
import com.tp_note.entities.concrete_actions.manage_events.events_types.AddPeriodiqueAction;
import com.tp_note.entities.concrete_actions.manage_events.events_types.AddRdvPersoAction;
import com.tp_note.entities.concrete_actions.manage_events.events_types.AddReunionAction;

public class ManageEventMenuActionList extends ActionList {
    private static ManageEventMenuActionList instance;

    private ManageEventMenuActionList() {
        super("Menu Gestionnaire d'Événements", new java.util.ArrayList<>(java.util.List.of(
                DisplayEventMenuActionList.getInstance(),
                AddRdvPersoAction.getInstance(),
                AddReunionAction.getInstance(),
                AddPeriodiqueAction.getInstance(),
                LogoutAction.getInstance()
        )));
    }

    public static ManageEventMenuActionList getInstance() {
        if (instance == null) {
            instance = new ManageEventMenuActionList();
        }
        return instance;
    }
}
