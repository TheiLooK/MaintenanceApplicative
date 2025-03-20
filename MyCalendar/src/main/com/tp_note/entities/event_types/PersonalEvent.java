package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;

import java.time.LocalDateTime;

public class PersonalEvent extends Event {
    public PersonalEvent(EventTitle title, User owner, LocalDateTime dateDebut, EventDuration duration) {
        super(title, owner, dateDebut, duration);
    }

    @Override
    public String description() {
        return title.title() + " le " + dateDebut.toString() + " durée : " + dureeMinutes.duration() + " minutes";
    }
}
