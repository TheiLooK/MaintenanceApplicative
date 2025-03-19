package com.tpnote.entities;

import com.tpnote.entities.primitives.*;

public class Event {
    public final EventType type;
    public final EventTitle title;
    public final EventOwner proprietaire;
    public final EventDate dateDebut;
    public final EventDuration dureeMinutes;

    public Event(EventType type, EventTitle title, EventOwner proprietaire, EventDate dateDebut, EventDuration dureeMinutes) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public String description() {
        return type.toString();
    }
}