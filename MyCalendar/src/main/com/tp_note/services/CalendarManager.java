package com.tp_note.services;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.*;

import java.time.LocalDateTime;

public class CalendarManager {
    public EventList events;

    public CalendarManager() {
        this.events = new EventList();
    }

    public EventList eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return new EventList(
                events.events.stream()
                .filter(e -> e.estDansPeriode(debut, fin))
                .toList()
        );
    }

    public void afficherEvenements() {
        events.events.stream().map(Event::description).forEach(DisplayService.getInstance()::printTexte);
    }

    public void ajouterEvent(Event e) {
        events.addEvent(e);
    }
}