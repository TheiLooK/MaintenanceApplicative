package com.tp_note.entities.concrete_actions.manage_events.events_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.manage_events.AddEventAction;
import com.tp_note.entities.event_types.Periodique;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
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
    public void DO() {
        event = createEvent();
        super.DO();
    }

    @Override
    protected Event createEvent() {
        DisplayService displayService = DisplayService.getInstance();

        displayService.printTexte("Ajout d'un événement périodique");

        String titre = displayService.printInputString("Entrez le titre de l'événement : ");
        LocalDateTime date = displayService.printInputDate();
        String dureeMinutes = displayService.printInputString("Entrez la durée de l'événement en minutes : ");

        // Spécification a l'événement périodique :
        String periode = displayService.printInputString("Entrez la période de l'événement en jours : ");

        return new Periodique(
            Integer.parseInt(periode),
            new EventTitle(titre),
            AuthService.getInstance().getLoggedUser(),
            date,
            new EventDuration(Integer.parseInt(dureeMinutes)
            )
        );
    }
}
