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

import java.time.LocalDateTime;
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

        displayService.printTexte("Ajout d'une conférence");

        String title = displayService.printInputString("Entrez le titre de la conférence : ");
        LocalDateTime date = displayService.printInputDate();
        int duration = displayService.printInputInt("Entrez la durée de la conférence en minutes : ");

        // Spécification de la conférence :
        String speakers = displayService.printInputString("Entrez les intervenants de la conférence (séparés par des virgules) : ");
        while (!Arrays.stream(speakers.split(",")).allMatch(p -> AuthService.getInstance().isRegistered(p))) {
            displayService.printTexte("Un des intervenants n'existe pas, veuillez réessayer");
            speakers = displayService.printInputString("Entrez les intervenants de la conférence (séparés par des virgules) : ");
        }
        String place = displayService.printInputString("Entrez le lieu de la conférence : ");

        return new ConferenceEvent(
            new UserList(speakers),
            new EventPlace(place),
            new EventTitle(title),
            AuthService.getInstance().getLoggedUser(),
            date,
            new EventDuration(duration)
        );
    }
}