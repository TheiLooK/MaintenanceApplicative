package com.tp_note.event_type;

import com.tp_note.entities.Event;
import com.tp_note.entities.event_types.MedicalAppointmentEvent;
import com.tp_note.entities.primitives.Doctor;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventPlace;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class MedicalAppointmentEventTest {
    @Test
    void testDescription() {
        Event medicalAppointmentEvent = new MedicalAppointmentEvent(
                new Doctor("Dr. Smith", "Cardiologist"),
                new EventPlace("Clinic A"),
                new EventTitle("Medical Appointment"),
                new User("Alice"),
                LocalDateTime.of(2023, 10, 10, 10, 0),
                new EventDuration(60)
        );

        medicalAppointmentEvent.setId(-13);

        String expectedDescription = """
                ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
                │ ===================================================== Rendez-vous Médical ====================================================== │
                │ Id : -13                                                                                                                         │
                │ Titre : Medical Appointment                                                                                                      │
                │ Propriétaire : Alice                                                                                                             │
                │ Date : 2023-10-10                                                                                                                │
                │ Heure : 10:00                                                                                                                    │
                │ Durée : 60 minutes                                                                                                               │
                │ Docteur : Dr. Smith (Cardiologist)                                                                                               │
                │ Lieu : Clinic A                                                                                                                  │
                └──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
                """;

        Assertions.assertEquals(expectedDescription, medicalAppointmentEvent.description());
    }

    @Test
    void testIsInPeriod() {
        Event medicalAppointmentEvent = new MedicalAppointmentEvent(
                new Doctor("Dr. Smith", "Cardiologist"),
                new EventPlace("Clinic A"),
                new EventTitle("Medical Appointment"),
                new User("Alice"),
                LocalDateTime.of(2023, 10, 10, 10, 0),
                new EventDuration(60)
        );

        Assertions.assertTrue(medicalAppointmentEvent.isInPeriod(
                LocalDateTime.of(2023, 10, 9, 0, 0),
                LocalDateTime.of(2023, 10, 11, 0, 0)
        ));

        Assertions.assertFalse(medicalAppointmentEvent.isInPeriod(
                LocalDateTime.of(2023, 10, 11, 0, 0),
                LocalDateTime.of(2023, 10, 12, 0, 0)
        ));
    }

    @Test
    void testHasAccess() {
        Event medicalAppointmentEvent = new MedicalAppointmentEvent(
                new Doctor("Dr. Smith", "Cardiologist"),
                new EventPlace("Clinic A"),
                new EventTitle("Medical Appointment"),
                new User("Alice"),
                LocalDateTime.of(2023, 10, 10, 10, 0),
                new EventDuration(60)
        );

        Assertions.assertTrue(medicalAppointmentEvent.hasAccess(new User("Alice")));
        Assertions.assertFalse(medicalAppointmentEvent.hasAccess(new User("Bob")));
    }
}