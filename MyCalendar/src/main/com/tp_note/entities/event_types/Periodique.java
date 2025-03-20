package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class Periodique extends Event {
    public final int frequenceJours;

    public Periodique(int frequenceJours, EventTitle title, User proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJours = frequenceJours;
    }

    @Override
    public String description() {
        return String.format("%s le %s durée : %d minutes, période : %d jours", title.title(), dateDebut.toString(), dureeMinutes.duration(), frequenceJours);
    }

    @Override
    public boolean estDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return Stream.iterate(dateDebut, d -> !d.isAfter(fin), d -> d.plusDays(frequenceJours))
                .anyMatch(d -> !d.isBefore(debut));
    }
}
