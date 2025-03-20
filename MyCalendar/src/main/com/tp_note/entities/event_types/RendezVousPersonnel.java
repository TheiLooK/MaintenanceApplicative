package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;

import java.time.LocalDateTime;

public class RendezVousPersonnel extends Event {
    public RendezVousPersonnel(EventTitle title, User proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
    }

    @Override
    public String description() {
        return title.title() + " le " + dateDebut.toString() + " durée : " + dureeMinutes.duration() + " minutes";
    }
}
