package com.tp_note.services;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.User;
import com.tp_note.entities.lists.ListEvent;

import java.time.LocalDateTime;

public class CalendarManager {
    private final ListEvent events;

    private static CalendarManager instance = null;

    public CalendarManager() {
        this.events = new ListEvent();
    }

    public static CalendarManager getInstance() {
        if (instance == null) {
            instance = new CalendarManager();
        }
        return instance;
    }

    public ListEvent eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return new ListEvent(
                getEventList().getEvents().stream()
                .filter(e -> e.estDansPeriode(debut, fin))
                .toList()
        );
    }

    public void ajouterEvent(Event e) {
        events.addEvent(e);
    }

    private ListEvent getEventList(User user) {
        return new ListEvent(
                events.getEvents().stream()
                .filter(e -> e.hasAccess(user))
                .toList()
        );
    }

    public ListEvent getEventList() {
        return getEventList(AuthService.getInstance().getLoggedUser());
    }
}