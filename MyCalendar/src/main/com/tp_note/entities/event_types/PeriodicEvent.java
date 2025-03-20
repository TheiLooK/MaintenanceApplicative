package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.PeriodicEventFrequency;
import com.tp_note.entities.primitives.User;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class PeriodicEvent extends Event {
    public final PeriodicEventFrequency frequency;

    public PeriodicEvent(PeriodicEventFrequency frequency, EventTitle title, User owner, LocalDateTime dateDebut, EventDuration duration) {
        super(title, owner, dateDebut, duration);
        this.frequency = frequency;
    }

    @Override
    public String description() {
        return String.format("%s le %s durée : %d minutes, période : %d jours", title.title(), dateDebut.toString(), dureeMinutes.duration(), frequency);
    }

    @Override
    public boolean isInPeriod(LocalDateTime debut, LocalDateTime fin) {
        return Stream.iterate(dateDebut, d -> !d.isAfter(fin), d -> d.plusDays(frequency.frequency()))
                .anyMatch(d -> !d.isBefore(debut));
    }
}
