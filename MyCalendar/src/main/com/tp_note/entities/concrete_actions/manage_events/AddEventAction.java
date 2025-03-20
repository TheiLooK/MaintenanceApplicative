package com.tp_note.entities.concrete_actions.manage_events;

import com.tp_note.entities.Action;
import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.menus.ManageEventMenuActionList;
import com.tp_note.services.CalendarManager;
import com.tp_note.services.DisplayService;

public abstract class AddEventAction extends Action {
    protected Event event;

    protected AddEventAction(String name) {
        super(name);
    }

    @Override
    public void perform() {
        CalendarManager.getInstance().addEvent(event);
        DisplayService.getInstance().printTexte(String.format("L'événement %s a été ajouté", name));
        ManageEventMenuActionList.getInstance().perform();
    }

    protected abstract Event createEvent();
}
