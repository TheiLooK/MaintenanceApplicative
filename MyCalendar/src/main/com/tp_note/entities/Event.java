package com.tp_note.entities;

import com.tp_note.entities.primitives.*;

import java.time.LocalDateTime;

public abstract class Event {
    public final EventTitle title;
    public final EventOwner proprietaire;
    public final LocalDateTime dateDebut;
    public final EventDuration dureeMinutes;

    protected Event(EventTitle title, EventOwner proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public abstract String description();

    public boolean estDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return dateDebut.isAfter(debut) && dateDebut.isBefore(fin);
    }
}