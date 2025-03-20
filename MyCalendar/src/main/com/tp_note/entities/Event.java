package com.tp_note.entities;

import com.tp_note.entities.primitives.*;

import java.time.LocalDateTime;

public abstract class Event {
    public final EventTitle title;
    public final User proprietaire;
    public final LocalDateTime dateDebut;
    public final EventDuration dureeMinutes;

    protected Event(EventTitle title, User proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public abstract String description();

    public boolean isInPeriod(LocalDateTime debut, LocalDateTime fin) {
        return dateDebut.isAfter(debut) && dateDebut.isBefore(fin);
    }

    public boolean hasAccess(User user) {
        return proprietaire.equals(user);
    }
}