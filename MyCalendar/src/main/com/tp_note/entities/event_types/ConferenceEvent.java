package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.lists.UserList;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventPlace;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;

import java.time.LocalDateTime;

public class ConferenceEvent extends Event {
    private final UserList speakers;
    private final EventPlace place;

    public ConferenceEvent(UserList speakers, EventPlace place, EventTitle title, User proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.speakers = speakers;
        this.place = place;
    }

    @Override
    public String description() {
        return "";
    }
}
