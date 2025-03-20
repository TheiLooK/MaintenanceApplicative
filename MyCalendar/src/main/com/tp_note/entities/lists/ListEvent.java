package com.tp_note.entities.lists;

import com.tp_note.entities.Event;
import com.tp_note.services.DisplayService;

import java.util.ArrayList;
import java.util.List;

public class ListEvent {
    private final List<Event> events;

    public ListEvent(List<Event> events) {
        this.events = events;
    }

    public ListEvent() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }

    public List<Event> getEvents() {
        return events;
    }

    public void afficher() {
        events.forEach(e -> DisplayService.getInstance().printTexte(e.description()));
    }
}
