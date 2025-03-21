package com.tp_note;

import com.tp_note.entities.Event;
import com.tp_note.entities.event_types.PeriodicEvent;
import com.tp_note.entities.event_types.PersonalEvent;
import com.tp_note.entities.event_types.MeetingEvent;
import com.tp_note.entities.event_types.TaskEvent;
import com.tp_note.entities.lists.UserList;
import com.tp_note.entities.primitives.*;
import com.tp_note.exceptions.auth.LogInException;
import com.tp_note.services.AuthService;
import com.tp_note.services.CalendarManager;
import com.tp_note.services.DisplayService;

import java.time.LocalDateTime;

public class DataGenerator {
    public static void generate() throws LogInException {
        DisplayService.getInstance().printTexte("Generating test data...");

        AuthService.getInstance().register("admin", "admin");
        AuthService.getInstance().register("Bob", "jaimealice");
        AuthService.getInstance().register("Alice", "jaimebob");

        AuthService.getInstance().logIn("admin", "admin");

        Event event1 = new PersonalEvent(
                new EventTitle("Corriger le TP de maintenance applicative"),
                AuthService.getInstance().getLoggedUser(),
                LocalDateTime.of(2025, 3, 26, 14, 0),
                new EventDuration(30)
        );

        Event event2 = new PeriodicEvent(
                new PeriodicEventFrequency(1),
                new EventTitle("Manger 5 fruits et légumes"),
                AuthService.getInstance().getLoggedUser(),
                LocalDateTime.of(2025, 3, 26, 9, 0),
                new EventDuration(60)
        );

        Event event3 = new MeetingEvent(
                new UserList("Bob,Alice"),
                new EventPlace("IUT Charlemange - Salle 105"),
                new EventTitle("Réunion de projet"),
                AuthService.getInstance().getLoggedUser(),
                LocalDateTime.of(2025, 3, 26, 10, 0),
                new EventDuration(30)
        );

        Event taskEvent = new TaskEvent(
                new TaskData("Faire les courses"),
                new EventTitle("Tache courses"),
                AuthService.getInstance().getLoggedUser(),
                LocalDateTime.of(2025, 3, 26, 12, 0),
                new EventDuration(30)
        );

        CalendarManager.getInstance().addEvent(event1);
        CalendarManager.getInstance().addEvent(event2);
        CalendarManager.getInstance().addEvent(event3);
        CalendarManager.getInstance().addEvent(taskEvent);

        AuthService.getInstance().logOut();

        DisplayService.getInstance().printTexte("Test data generated.");
    }
}
