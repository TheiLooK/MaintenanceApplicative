package com.tp_note.services;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.User;
import com.tp_note.entities.lists.EventList;

import java.time.LocalDateTime;

public class CalendarManager {
    private final EventList events;

    private static CalendarManager instance = null;

    public CalendarManager() {
        this.events = new EventList();
    }

    public static CalendarManager getInstance() {
        if (instance == null) {
            instance = new CalendarManager();
        }
        return instance;
    }

    public EventList eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return new EventList(
                getEventList().getEvents().stream()
                .filter(e -> e.isInPeriod(debut, fin))
                .toList()
        );
    }

    public void addEvent(Event e) {
        events.addEvent(e);
    }

    private EventList getEventList(User user) {
        return new EventList(
                events.getEvents().stream()
                .filter(e -> e.hasAccess(user))
                .toList()
        );
    }

    public EventList getEventList() {
        return getEventList(AuthService.getInstance().getLoggedUser());
    }
}