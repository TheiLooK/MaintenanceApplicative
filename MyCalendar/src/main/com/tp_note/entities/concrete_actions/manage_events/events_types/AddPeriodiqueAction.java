package com.tp_note.entities.concrete_actions.manage_events.events_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.manage_events.AddEventAction;
import com.tp_note.entities.event_types.Periodique;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventOwner;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

import java.time.LocalDateTime;

public class AddPeriodiqueAction extends AddEventAction {
    public AddPeriodiqueAction() {
        super("Ajouter un événement périodique");
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
        String proprietaire = AuthService.getInstance().getLoggedUser().name();

        LocalDateTime date = displayService.printInputDate();

        String dureeMinutes = displayService.printInputString("Entrez la durée de l'événement en minutes : ");

        // Spécification a l'événement périodique :
        String periode = displayService.printInputString("Entrez la période de l'événement en jours : ");

        return new Periodique(
            Integer.parseInt(periode),
            new EventTitle(titre),
            new EventOwner(proprietaire),
            date,
            new EventDuration(Integer.parseInt(dureeMinutes)
            )
        );
    }
}
