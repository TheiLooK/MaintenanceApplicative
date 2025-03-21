package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;

import java.time.LocalDateTime;
import java.util.List;

public class PersonalEvent extends Event {
    public PersonalEvent(EventTitle title, User owner, LocalDateTime dateDebut, EventDuration duration) {
        super(title, owner, dateDebut, duration);
    }

    @Override
    public String description() {
        List<String> content = List.of(
                "Id : " + id,
                "Titre : " + title.title(),
                "Propriétaire : " + owner.name(),
                "Date : " + dateDebut.toLocalDate(),
                "Heure : " + dateDebut.toLocalTime().toString().substring(0, 5),
                "Durée : " + dureeMinutes.duration() + " minutes"
        );

        return generateDescription(content, "Événement Personnel");
    }
}
