package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.EventPlace;
import com.tp_note.entities.primitives.User;
import com.tp_note.entities.lists.UserList;

import java.time.LocalDateTime;
import java.util.List;

public class MeetingEvent extends Event {
    public final UserList participants;
    public final EventPlace eventPlace;

    public MeetingEvent(UserList participants, EventPlace eventPlace, EventTitle title, User owner, LocalDateTime dateDebut, EventDuration duration) {
        super(title, owner, dateDebut, duration);
        this.participants = participants;
        this.eventPlace = eventPlace;
    }

    @Override
    public String description() {
        List<String> content = List.of(
                "Titre : " + title.title(),
                "Propriétaire : " + proprietaire.name(),
                "Date : " + dateDebut.toLocalDate(),
                "Heure : " + dateDebut.toLocalTime().toString().substring(0, 5),
                "Durée : " + dureeMinutes.duration() + " minutes",
                "Lieu : " + eventPlace.toString(),
                "Participants : " + participants.toString()
        );

        return generateDescription(content, "Réunion");
    }

    @Override
    public boolean hasAccess(User user) {
        return super.hasAccess(user) || participants.contains(user);
    }
}
