package com.tpnote.entities;

import com.tpnote.entities.primitives.*;
import com.tpnote.entities.primitives.event_type.Periodique;
import com.tpnote.entities.primitives.event_type.Reunion;

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
        return switch (type.type) {
            case REUNION -> {
                Reunion reunion = (Reunion) type;
                yield String.format("Reunion avec %s à %s", reunion.participants, reunion.lieu);
            }
            case PERIODIQUE -> {
                Periodique periodique = (Periodique) type;
                yield String.format("Evenement periodique tous les %d jours", periodique.frequenceJours);
            }
            case RDV_PERSONNEL -> "Rendez-vous personnel";
        };
    }
}