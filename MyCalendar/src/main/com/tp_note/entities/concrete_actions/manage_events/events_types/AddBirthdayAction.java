package com.tp_note.entities.concrete_actions.manage_events.events_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.manage_events.AddEventAction;
import com.tp_note.entities.event_types.BirthdayEvent;
import com.tp_note.entities.primitives.BirthdayYear;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

public class AddBirthdayAction extends AddEventAction {
    private static AddBirthdayAction instance;

    private AddBirthdayAction() {
        super("Ajouter un anniversaire");
    }

    public static AddBirthdayAction getInstance() {
        if (instance == null) {
            instance = new AddBirthdayAction();
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

        displayService.printTexte("Ajout d'un anniversaire");

        String celebratedPerson = displayService.printInputString("Entrez le nom de la personne célébrée : ");
        while (!AuthService.getInstance().isRegistered(celebratedPerson)) {
            displayService.printTexte("La personne célébrée n'existe pas dans la liste des utilisateurs.");
            celebratedPerson = displayService.printInputString("Entrez le nom de la personne célébrée : ");
        }
        int birthdayYear = displayService.printInputInt("Entrez l'année de naissance de la personne célébrée : ");

        return new BirthdayEvent(
                new User(celebratedPerson),
                new BirthdayYear(birthdayYear),
                new EventTitle(details.title()),
                AuthService.getInstance().getLoggedUser(),
                details.date(),
                new EventDuration(details.duration())
        );
    }
}