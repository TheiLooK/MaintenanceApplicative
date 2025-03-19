package com.tp_note.entities.concrete_actions.menus;

import com.tp_note.entities.ListAction;
import com.tp_note.entities.concrete_actions.auth.LogoutAction;
import com.tp_note.entities.concrete_actions.manage_events.events_types.AddPeriodiqueAction;
import com.tp_note.entities.concrete_actions.manage_events.events_types.AddRdvPersoAction;
import com.tp_note.entities.concrete_actions.manage_events.events_types.AddReunionAction;

public class ManageEventMenuAction extends ListAction {
    public ManageEventMenuAction() {
        super("Menu Gestionnaire d'Événements", new java.util.ArrayList<>(java.util.List.of(
                new DisplayEventMenuAction(),
                new AddRdvPersoAction(),
                new AddReunionAction(),
                new AddPeriodiqueAction(),
                new LogoutAction()
        )));
    }
}
