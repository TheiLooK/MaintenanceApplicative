package com.tpnote.entities.primitives.event_type;

import com.tpnote.entities.Event;
import com.tpnote.entities.primitives.EventDuration;
import com.tpnote.entities.primitives.EventOwner;
import com.tpnote.entities.primitives.EventTitle;

import java.time.LocalDateTime;

public class Reunion extends Event {
    public final String participants;
    public final String lieu;

    public Reunion(String participants, String lieu, EventTitle title, EventOwner proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.participants = participants;
        this.lieu = lieu;
    }

    @Override
    public String description() {
        return String.format("Reunion avec %s à %s", participants, lieu);
    }
}
