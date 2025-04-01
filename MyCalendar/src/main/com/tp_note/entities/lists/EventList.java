package com.tp_note.entities.lists;

import com.tp_note.entities.Event;
import com.tp_note.entities.event_types.PeriodicEvent;
import com.tp_note.entities.primitives.Id;
import com.tp_note.entities.primitives.User;
import com.tp_note.exceptions.events.DeleteEventException;
import com.tp_note.exceptions.events.delete_event.EventMustBeOwnerToDeleteException;
import com.tp_note.exceptions.events.delete_event.EventNotFoundException;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class EventList {
    private List<Event> events;

    public EventList(List<Event> events) {
        this.events = events;
    }

    public EventList() {
        this.events = new ArrayList<>();
    }

    public static EventList empty() {
        return new EventList(new ArrayList<>());
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }

    public void removeEvent(Id id) throws DeleteEventException {
        Event eventToRemove = events.stream()
                .filter(event -> event.id.equals(id))
                .findFirst()
                .orElseThrow(EventNotFoundException::new);

        User currentUser = AuthService.getInstance().getLoggedUser();
        if (!eventToRemove.owner.equals(currentUser)) {
            throw new EventMustBeOwnerToDeleteException();
        }

        events.remove(eventToRemove);
    }

    public void display() {
        events.forEach(e -> DisplayService.getInstance().printMultipleLines(e.description()));
    }

    public boolean isConflict(Event event) {
        if (!(event instanceof PeriodicEvent periodicEvent)) {
            return events.stream().anyMatch(e -> e.isConflict(event));
        }

        LocalDateTime start = periodicEvent.dateDebut;
        LocalDateTime end = start.plusMinutes(periodicEvent.dureeMinutes.duration());
        int periodDays = periodicEvent.frequency.frequency();

        return events.stream().anyMatch(e -> {
            LocalDateTime tempStart = start;
            LocalDateTime tempEnd = end;
            while (tempStart.isBefore(e.dateDebut.plusDays(e.dureeMinutes.duration()))) {
                if (e.isConflict(new PeriodicEvent(periodicEvent.frequency, periodicEvent.title, periodicEvent.owner, tempStart, periodicEvent.dureeMinutes))) {
                    return true;
                }
                tempStart = tempStart.plusDays(periodDays);
                tempEnd = tempEnd.plusDays(periodDays);
            }
            return false;
        });
    }
}