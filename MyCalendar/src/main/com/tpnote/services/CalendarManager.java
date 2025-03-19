package com.tpnote.services;

import com.tpnote.entities.Event;
import com.tpnote.entities.primitives.*;

import java.time.LocalDateTime;
import java.util.List;

public class CalendarManager {
    public EventList events;

    public CalendarManager() {
        this.events = new EventList();
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return events.events.stream()
            .filter(e -> e.estDansPeriode(debut, fin))
            .toList();
    }

    public void afficherEvenements() {
        events.events.stream().map(Event::description).forEach(System.out::println);
    }

    public void ajouterEvent(Event e) {
        events.addEvent(e);
    }
}