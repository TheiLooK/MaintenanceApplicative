package com.tp_note.entities.concrete_actions.manage_events;

import com.tp_note.entities.Action;
import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.menus.ManageEventMenuActionList;
import com.tp_note.services.CalendarManager;
import com.tp_note.services.DisplayService;

import java.time.LocalDateTime;

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

    protected EventDetails getCommonEventDetails() {
        DisplayService displayService = DisplayService.getInstance();

        displayService.printTexte("Ajout d'un événement");
        String title = displayService.printInputString("Entrez le titre de l'événement : ");
        LocalDateTime date = displayService.printInputDate();
        int duration = displayService.printInputInt("Entrez la durée de l'événement en minutes : ");

        return new EventDetails(title, date, duration);
    }

    protected record EventDetails(String title, LocalDateTime date, int duration) {
    }
}