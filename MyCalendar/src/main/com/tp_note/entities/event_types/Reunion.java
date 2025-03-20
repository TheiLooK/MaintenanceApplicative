package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;
import com.tp_note.entities.lists.ListUser;

import java.time.LocalDateTime;

public class Reunion extends Event {
    public final ListUser participants;
    public final String lieu;

    public Reunion(ListUser participants, String lieu, EventTitle title, User proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.participants = participants;
        this.lieu = lieu;
    }

    @Override
    public String description() {
        return String.format("%s le %s durée : %d minutes, lieu : %s, participants : %s", title.title(), dateDebut.toString(), dureeMinutes.duration(), lieu, participants);
    }

    @Override
    public boolean hasAccess(User user) {
        return super.hasAccess(user) || participants.contains(user);
    }
}
