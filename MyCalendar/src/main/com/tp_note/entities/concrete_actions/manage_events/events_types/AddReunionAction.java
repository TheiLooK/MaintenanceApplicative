package com.tp_note.entities.concrete_actions.manage_events.events_types;

import com.tp_note.entities.concrete_actions.manage_events.AddEventAction;
import com.tp_note.entities.event_types.MeetingEvent;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.lists.UserList;
import com.tp_note.entities.primitives.MeetingEventPlace;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

import java.time.LocalDateTime;
import java.util.Arrays;

public class AddReunionAction extends AddEventAction {
    private static AddReunionAction instance;

    private AddReunionAction() {
        super("Ajouter une réunion");
    }

    public static AddReunionAction getInstance() {
        if (instance == null) {
            instance = new AddReunionAction();
        }
        return instance;
    }

    @Override
    public void perform() {
        event = createEvent();
        super.perform();
    }

    @Override
    public MeetingEvent createEvent() {
        DisplayService displayService = DisplayService.getInstance();

        displayService.printTexte("Ajout d'une réunion");

        String title = displayService.printInputString("Entrez le titre de la réunion : ");
        LocalDateTime date = displayService.printInputDate();
        int duration = displayService.printInputInt("Entrez la durée de la réunion en minutes : ");

        // Spécification de la réunion :
        String participants = displayService.printInputString("Entrez les participants de la réunion (séparés par des virgules) : ");
        // Si in des participants n'existe pas, on demande à l'utilisateur de recommencer
        while (!Arrays.stream(participants.split(",")).allMatch(p -> AuthService.getInstance().isRegistered(p))) {
            displayService.printTexte("Un des participants n'existe pas, veuillez réessayer");
            participants = displayService.printInputString("Entrez les participants de la réunion (séparés par des virgules ex: Jean,Michel) : ");
        }
        String place = displayService.printInputString("Entrez le lieu de la réunion : ");

        return new MeetingEvent(
            new UserList(participants),
            new MeetingEventPlace(place),
            new EventTitle(title),
            AuthService.getInstance().getLoggedUser(),
            date,
            new EventDuration(duration)
        );
    }
}
