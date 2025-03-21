package com.tp_note.entities.concrete_actions.manage_events.events_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.manage_events.AddEventAction;
import com.tp_note.entities.event_types.MeetingEvent;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.lists.UserList;
import com.tp_note.entities.primitives.EventPlace;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

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
    protected Event createEvent() {
        DisplayService displayService = DisplayService.getInstance();
        EventDetails details = getCommonEventDetails();

        displayService.printTexte("Ajout d'une réunion");

        String participants = displayService.printInputString("Entrez les participants de la réunion (séparés par des virgules) : ");
        while (!Arrays.stream(participants.split(",")).allMatch(p -> AuthService.getInstance().isRegistered(p))) {
            displayService.printTexte("Un des participants n'existe pas, veuillez réessayer");
            participants = displayService.printInputString("Entrez les participants de la réunion (séparés par des virgules) : ");
        }
        String place = displayService.printInputString("Entrez le lieu de la réunion : ");

        return new MeetingEvent(
                new UserList(participants),
                new EventPlace(place),
                new EventTitle(details.title()),
                AuthService.getInstance().getLoggedUser(),
                details.date(),
                new EventDuration(details.duration())
        );
    }
}