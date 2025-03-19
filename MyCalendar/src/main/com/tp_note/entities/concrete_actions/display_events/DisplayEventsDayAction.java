package com.tp_note.entities.concrete_actions.display_events;

import com.tp_note.entities.Action;
import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.menus.DisplayEventMenuAction;
import com.tp_note.services.AuthService;
import com.tp_note.services.CalendarManager;
import com.tp_note.services.DisplayService;

import java.time.LocalDateTime;

public class DisplayEventsDayAction extends Action {
    public DisplayEventsDayAction() {
        super("Afficher les événements d'un JOUR précis");
    }

    @Override
    public void DO() {
        DisplayService displayService = DisplayService.getInstance();
        CalendarManager calendarManager = AuthService.getInstance().getLoggedUser().calendar();

        LocalDateTime date = displayService.printInputDate();

        calendarManager.eventsDansPeriode(date, date.plusDays(1)).events.stream().map(Event::description).forEach(displayService::printTexte);

        DisplayService.getInstance().Continue();
        new DisplayEventMenuAction().DO();
    }
}
