package com.tpnote.entities.event_type;

import com.tpnote.entities.Event;
import com.tpnote.entities.primitives.EventDuration;
import com.tpnote.entities.primitives.EventOwner;
import com.tpnote.entities.primitives.EventTitle;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class Periodique extends Event {
    public final int frequenceJours;

    public Periodique(int frequenceJours, EventTitle title, EventOwner proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJours = frequenceJours;
    }

    @Override
    public String description() {
        return String.format("Evenement periodique tous les %d jours", frequenceJours);
    }

    @Override
    public boolean estDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return Stream.iterate(dateDebut, d -> !d.isAfter(fin), d -> d.plusDays(frequenceJours))
                .anyMatch(d -> !d.isBefore(debut));
    }
}
