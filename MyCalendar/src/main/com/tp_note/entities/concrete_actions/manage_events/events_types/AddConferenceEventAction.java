package com.tp_note.entities.concrete_actions.manage_events.events_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.manage_events.AddEventAction;
import com.tp_note.entities.event_types.ConferenceEvent;
import com.tp_note.entities.lists.UserList;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventPlace;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

import java.util.Arrays;

public class AddConferenceEventAction extends AddEventAction {
    private static AddConferenceEventAction instance;

    private AddConferenceEventAction() {
        super("Ajouter une conférence");
    }

    public static AddConferenceEventAction getInstance() {
        if (instance == null) {
            instance = new AddConferenceEventAction();
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

        displayService.printTexte("Ajout d'une conférence");

        String speakers = displayService.printInputString("Entrez les intervenants de la conférence (séparés par des virgules) : ");
        while (!Arrays.stream(speakers.split(",")).allMatch(p -> AuthService.getInstance().isRegistered(p))) {
            displayService.printTexte("Un des intervenants n'existe pas, veuillez réessayer");
            speakers = displayService.printInputString("Entrez les intervenants de la conférence (séparés par des virgules) : ");
        }
        String place = displayService.printInputString("Entrez le lieu de la conférence : ");

        return new ConferenceEvent(
                new UserList(speakers),
                new EventPlace(place),
                new EventTitle(details.title()),
                AuthService.getInstance().getLoggedUser(),
                details.date(),
                new EventDuration(details.duration())
        );
    }
}