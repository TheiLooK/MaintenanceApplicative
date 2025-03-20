package com.tp_note.entities.concrete_actions.menus;

import com.tp_note.entities.lists.ListAction;
import com.tp_note.entities.concrete_actions.auth.LogoutAction;
import com.tp_note.entities.concrete_actions.manage_events.events_types.AddPeriodiqueAction;
import com.tp_note.entities.concrete_actions.manage_events.events_types.AddRdvPersoAction;
import com.tp_note.entities.concrete_actions.manage_events.events_types.AddReunionAction;

public class ManageEventMenuAction extends ListAction {
    private static ManageEventMenuAction instance;

    private ManageEventMenuAction() {
        super("Menu Gestionnaire d'Événements", new java.util.ArrayList<>(java.util.List.of(
                DisplayEventMenuAction.getInstance(),
                AddRdvPersoAction.getInstance(),
                AddReunionAction.getInstance(),
                AddPeriodiqueAction.getInstance(),
                LogoutAction.getInstance()
        )));
    }

    public static ManageEventMenuAction getInstance() {
        if (instance == null) {
            instance = new ManageEventMenuAction();
        }
        return instance;
    }
}
