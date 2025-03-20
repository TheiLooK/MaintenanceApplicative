package com.tp_note.entities.concrete_actions.manage_events;

import com.tp_note.entities.Action;
import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.menus.ManageEventMenuAction;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

public abstract class AddEventAction extends Action {
    protected Event event;

    protected AddEventAction(String name) {
        super(name);
    }

    @Override
    public void DO() {
        AuthService.getInstance().getLoggedUser().calendar().ajouterEvent(event);
        DisplayService.getInstance().printTexte(String.format("L'événement %s a été ajouté", name));
        ManageEventMenuAction.getInstance().DO();
    }

    protected abstract Event createEvent();
}
