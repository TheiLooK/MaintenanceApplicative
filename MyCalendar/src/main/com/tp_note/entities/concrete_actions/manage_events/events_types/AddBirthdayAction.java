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

import java.time.LocalDateTime;

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

        displayService.printTexte("Ajout d'un anniversaire");

        String title = displayService.printInputString("Entrez le titre de l'événement : ");
        LocalDateTime date = displayService.printInputDate();
        int duration = displayService.printInputInt("Entrez la durée de l'événement en minutes : ");

        // Spécification a l'événement anniversaire :
        String celebratedPerson = displayService.printInputString("Entrez le nom de la personne célébrée : ");
        // Check si la personne célébrée est déjà dans la liste des utilisateurs
        while (!AuthService.getInstance().isRegistered(celebratedPerson)) {
            displayService.printTexte("La personne célébrée n'existe pas dans la liste des utilisateurs.");
            celebratedPerson = displayService.printInputString("Entrez le nom de la personne célébrée : ");
        }
        int birthdayYear = displayService.printInputInt("Entrez l'année de naissance de la personne célébrée : ");

        return new BirthdayEvent(
            new User(celebratedPerson),
            new BirthdayYear(birthdayYear),
            new EventTitle(title),
            AuthService.getInstance().getLoggedUser(),
            date,
            new EventDuration(duration)
        );
    }
}
