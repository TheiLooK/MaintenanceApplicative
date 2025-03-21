package com.tp_note.services;

import com.tp_note.entities.Event;
import com.tp_note.entities.event_types.TaskEvent;
import com.tp_note.entities.lists.event.TaskEventList;
import com.tp_note.entities.primitives.Id;
import com.tp_note.entities.primitives.User;
import com.tp_note.entities.lists.EventList;
import com.tp_note.exceptions.events.DeleteEventException;
import com.tp_note.exceptions.events.EventConflictException;

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

    public void addEvent(Event e) throws EventConflictException {
        if (events.isConflict(e)) {
            throw new EventConflictException();
        }
        events.addEvent(e);
    }

    public void removeEvent(Id id) throws DeleteEventException {
        events.removeEvent(id);
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

    public TaskEventList getTasks() {
        return new TaskEventList(
                getEventList().getEvents().stream()
                .filter(TaskEvent.class::isInstance)
                .map(e -> (TaskEvent) e)
                .toList()
        );
    }
}