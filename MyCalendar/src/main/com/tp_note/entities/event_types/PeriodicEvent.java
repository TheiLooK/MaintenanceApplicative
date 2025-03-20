package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.PeriodicEventFrequency;
import com.tp_note.entities.primitives.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class PeriodicEvent extends Event {
    public final PeriodicEventFrequency frequency;

    public PeriodicEvent(PeriodicEventFrequency frequency, EventTitle title, User owner, LocalDateTime dateDebut, EventDuration duration) {
        super(title, owner, dateDebut, duration);
        this.frequency = frequency;
    }

    @Override
    public String description() {
        List<String> content = List.of(
                "Titre : " + title.title(),
                "Propriétaire : " + proprietaire.name(),
                "Date : " + dateDebut.toLocalDate(),
                "Heure : " + dateDebut.toLocalTime().toString().substring(0, 5),
                "Durée : " + dureeMinutes.duration() + " minutes",
                "Périodicité : " + frequency.frequency() + " jours"
        );

        return generateDescription(content, "Événement Périodique");
    }

    @Override
    public boolean isInPeriod(LocalDateTime debut, LocalDateTime fin) {
        return Stream.iterate(dateDebut, d -> !d.isAfter(fin), d -> d.plusDays(frequency.frequency()))
                .anyMatch(d -> !d.isBefore(debut));
    }
}
