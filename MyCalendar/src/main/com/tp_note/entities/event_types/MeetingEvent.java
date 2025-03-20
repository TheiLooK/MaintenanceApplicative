package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.MeetingEventPlace;
import com.tp_note.entities.primitives.User;
import com.tp_note.entities.lists.UserList;

import java.time.LocalDateTime;

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
        return String.format("%s le %s durée : %d minutes, lieu : %s, participants : %s", title.title(), dateDebut.toString(), dureeMinutes.duration(), meetingEventPlace, participants);
    }

    @Override
    public boolean hasAccess(User user) {
        return super.hasAccess(user) || participants.contains(user);
    }
}
