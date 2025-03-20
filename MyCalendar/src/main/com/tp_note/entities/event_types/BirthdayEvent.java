package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;
import com.tp_note.entities.primitives.BirthdayYear;

import java.time.LocalDateTime;

public class BirthdayEvent extends Event {
    private final User celebratedPerson;
    private final BirthdayYear birthdayYear;

    public BirthdayEvent(User celebratedPerson, BirthdayYear birthdayYear, EventTitle title, User proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.celebratedPerson = celebratedPerson;
        this.birthdayYear = birthdayYear;
    }

    @Override
    public String description() {
        return "";
    }

}
