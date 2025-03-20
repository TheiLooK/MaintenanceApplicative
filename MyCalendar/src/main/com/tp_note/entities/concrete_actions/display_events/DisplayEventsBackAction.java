package com.tp_note.entities.concrete_actions.display_events;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.ManageEventMenuAction;

public class DisplayEventsBackAction extends Action {
    private static DisplayEventsBackAction instance;

    private DisplayEventsBackAction() {
        super("Retour");
    }

    public static DisplayEventsBackAction getInstance() {
        if (instance == null) {
            instance = new DisplayEventsBackAction();
        }
        return instance;
    }

    @Override
    public void DO() {
        ManageEventMenuAction.getInstance().DO();
    }
}
