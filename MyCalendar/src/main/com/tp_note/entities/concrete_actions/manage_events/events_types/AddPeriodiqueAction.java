package com.tp_note.entities.concrete_actions.manage_events.events_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.manage_events.AddEventAction;
import com.tp_note.entities.event_types.PeriodicEvent;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.PeriodicEventFrequency;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

import java.time.LocalDateTime;

public class AddPeriodiqueAction extends AddEventAction {
    private static AddPeriodiqueAction instance;

    private AddPeriodiqueAction() {
        super("Ajouter un événement périodique");
    }

    public static AddPeriodiqueAction getInstance() {
        if (instance == null) {
            instance = new AddPeriodiqueAction();
        }
        return instance;
    }

    @Override
    public void perform() {
        event = createEvent();
        super.perform();
    }

    @Override
    protected Event createEvent() {
        DisplayService displayService = DisplayService.getInstance();

        displayService.printTexte("Ajout d'un événement périodique");

        String title = displayService.printInputString("Entrez le titre de l'événement : ");
        LocalDateTime date = displayService.printInputDate();
        int duration = displayService.printInputInt("Entrez la durée de l'événement en minutes : ");

        // Spécification a l'événement périodique :
        int period = displayService.printInputInt("Entrez la période de l'événement en jours : ");

        return new PeriodicEvent(
            new PeriodicEventFrequency(period),
            new EventTitle(title),
            AuthService.getInstance().getLoggedUser(),
            date,
            new EventDuration(duration)
        );
    }
}
