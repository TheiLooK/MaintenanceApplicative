package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.MeetingEventPlace;
import com.tp_note.entities.primitives.User;
import com.tp_note.entities.lists.UserList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingEvent extends Event {
    public final UserList participants;
    public final MeetingEventPlace meetingEventPlace;

    public MeetingEvent(UserList participants, MeetingEventPlace meetingEventPlace, EventTitle title, User owner, LocalDateTime dateDebut, EventDuration duration) {
        super(title, owner, dateDebut, duration);
        this.participants = participants;
        this.meetingEventPlace = meetingEventPlace;
    }

    @Override
    public String description() {
        List<String> content = List.of(
                "Titre : " + title.title(),
                "Propriétaire : " + proprietaire.name(),
                "Date : " + dateDebut.toLocalDate(),
                "Heure : " + dateDebut.toLocalTime().toString().substring(0, 5),
                "Durée : " + dureeMinutes.duration() + " minutes",
                "Lieu : " + meetingEventPlace.toString(),
                "Participants : " + participants.toString()
        );

        return generateDescription(content, "Réunion");
    }

    @Override
    public boolean hasAccess(User user) {
        return super.hasAccess(user) || participants.contains(user);
    }
}
