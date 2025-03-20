package com.tp_note.entities.concrete_actions.manage_events.events_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.manage_events.AddEventAction;
import com.tp_note.entities.event_types.RendezVousPersonnel;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

import java.time.LocalDateTime;

public class AddRdvPersoAction extends AddEventAction {
    private static AddRdvPersoAction instance;

    private AddRdvPersoAction() {
        super("Ajouter un rendez-vous personnel");
    }

    public static AddRdvPersoAction getInstance() {
        if (instance == null) {
            instance = new AddRdvPersoAction();
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

        displayService.printTexte("Ajout d'un rendez-vous personnel");

        String titre = displayService.printInputString("Entrez le titre du rendes-vous : ");
        LocalDateTime date = displayService.printInputDate();
        String dureeMinutes = displayService.printInputString("Entrez la durée du rendez-vous en minutes : ");

        // Spécification au rendez-vous personnel :
        // Rien pour l'instant

        return new RendezVousPersonnel(
                new EventTitle(titre),
                AuthService.getInstance().getLoggedUser(),
                date,
                new EventDuration(Integer.parseInt(dureeMinutes)
            )
        );
    }
}
