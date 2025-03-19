package com.tpnote.services;

import com.tpnote.entities.Event;
import com.tpnote.entities.enums.EventTypeEnum;
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

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.dateDebut.plusMinutes(e1.dureeMinutes);
        LocalDateTime fin2 = e2.dateDebut.plusMinutes(e2.dureeMinutes);

        if (e1.type.equals(EventTypeEnum.PERIODIQUE) || e2.type.equals(EventTypeEnum.PERIODIQUE)) {
            return false; // Simplification abusive
        }

        return e1.dateDebut.date().isBefore(fin2) && fin1.isAfter(e2.dateDebut);
    }

    public void afficherEvenements() {
        events.events.stream().map(Event::description).forEach(System.out::println);
    }
}