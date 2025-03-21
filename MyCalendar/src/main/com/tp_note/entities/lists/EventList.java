package com.tp_note.entities.lists;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.Id;
import com.tp_note.services.DisplayService;

import java.util.ArrayList;
import java.util.List;

public class EventList {
    private final List<Event> events;

    public EventList(List<Event> events) {
        this.events = events;
    }

    public EventList() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }

    public void removeEvent(Id id) {
        events.removeIf(e -> e.id.equals(id));
    }

    public List<Event> getEvents() {
        return events;
    }

    public void display() {
        events.forEach(e -> DisplayService.getInstance().printMultipleLines(e.description()));
    }
}
