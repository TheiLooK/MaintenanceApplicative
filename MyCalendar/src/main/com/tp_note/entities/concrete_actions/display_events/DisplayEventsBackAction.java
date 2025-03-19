package com.tp_note.entities.concrete_actions.display_events;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.ManageEventMenuAction;
import com.tp_note.services.DisplayService;

public class DisplayEventsBackAction extends Action {
    public DisplayEventsBackAction() {
        super("Retour");
    }

    @Override
    public void DO() {
        new ManageEventMenuAction().DO();
    }
}
