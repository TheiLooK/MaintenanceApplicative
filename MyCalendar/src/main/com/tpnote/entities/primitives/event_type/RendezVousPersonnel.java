package com.tpnote.entities.primitives.event_type;

import com.tpnote.entities.Event;
import com.tpnote.entities.primitives.EventDuration;
import com.tpnote.entities.primitives.EventOwner;
import com.tpnote.entities.primitives.EventTitle;

import java.time.LocalDateTime;

public class RendezVousPersonnel extends Event {
    public RendezVousPersonnel(EventTitle title, EventOwner proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
    }

    @Override
    public String description() {
        return "Rendez-vous personnel";
    }
}
