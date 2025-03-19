package com.tp_note.entities.concrete_actions.manage_events.events_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.manage_events.AddEventAction;
import com.tp_note.entities.event_types.RendezVousPersonnel;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventOwner;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

import java.time.LocalDateTime;

public class AddRdvPersoAction extends AddEventAction {
    public AddRdvPersoAction() {
        super("rendez-vous personnel");
        this.event = createEvent();
    }

    @Override
    protected Event createEvent() {
        DisplayService displayService = DisplayService.getInstance();

        displayService.printTexte("Ajout d'un rendez-vous personnel");

        String titre = displayService.printInputString("Entrez le titre du rendes-vous : ");
        String proprietaire = AuthService.getInstance().getLoggedUser().name();

        LocalDateTime date = displayService.printInputDate();

        String dureeMinutes = displayService.printInputString("Entrez la durée du rendez-vous en minutes : ");

        // Spécification au rendez-vous personnel :
        // Rien pour l'instant

        return new RendezVousPersonnel(
                new EventTitle(titre),
                new EventOwner(proprietaire),
                date,
                new EventDuration(Integer.parseInt(dureeMinutes)
            )
        );
    }
}
