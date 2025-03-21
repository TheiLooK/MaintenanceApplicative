package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.*;

import java.time.LocalDateTime;
import java.util.List;

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
        List<String> content = List.of(
                "Id : " + id,
                "Titre : " + title.title(),
                "Propriétaire : " + owner.name(),
                "Date : " + dateDebut.toLocalDate(),
                "Heure : " + dateDebut.toLocalTime().toString().substring(0, 5),
                "Durée : " + dureeMinutes.duration() + " minutes",
                "Docteur : " + doctor,
                "Lieu : " + place
        );

        return generateDescription(content, "Rendez-vous Médical");
    }
}
