package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventOwner;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;

import java.time.LocalDateTime;
import java.util.List;

public class Reunion extends Event {
    public final List<String> participants;
    public final String lieu;

    public Reunion(List<String> participants, String lieu, EventTitle title, EventOwner proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.participants = participants;
        this.lieu = lieu;
    }

    @Override
    public String description() {
        return String.format("Reunion avec %s à %s", participants, lieu);
    }
}
