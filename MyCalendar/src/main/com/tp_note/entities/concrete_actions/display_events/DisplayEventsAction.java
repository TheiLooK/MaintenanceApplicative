package com.tp_note.entities.concrete_actions.display_events;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.DisplayEventMenuAction;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

public class DisplayEventsAction extends Action {
    public DisplayEventsAction() {
        super("Afficher les événements");
    }

    @Override
    public void DO() {
        DisplayService.getInstance().printTitre("Liste des événements :");
        AuthService.getInstance().getLoggedUser().calendar().afficherEvenements();
        DisplayService.getInstance().Continue();
        new DisplayEventMenuAction().DO();
    }
}
