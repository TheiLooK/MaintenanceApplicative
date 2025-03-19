package com.tp_note.entities.primitives;

import com.tp_note.entities.Event;

import java.util.ArrayList;
import java.util.List;

public class EventList {
    public List<Event> events;

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

    public List<Event> getEvents() {
        return events;
    }
}
