package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.*;

import java.time.LocalDateTime;

public class MedicalAppointmentEvent extends Event {
    private Doctor doctor;
    private EventPlace place;

    public MedicalAppointmentEvent(Doctor doctor, EventPlace place, EventTitle title, User proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.doctor = doctor;
        this.place = place;
    }

    @Override
    public String description() {
        return "";
    }
}
