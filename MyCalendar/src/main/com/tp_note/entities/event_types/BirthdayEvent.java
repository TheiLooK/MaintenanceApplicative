package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;
import com.tp_note.entities.primitives.BirthdayYear;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class BirthdayEvent extends Event {
    private User celebratedPerson;
    private BirthdayYear birthdayYear;

    public BirthdayEvent(User celebratedPerson, BirthdayYear birthdayYear, EventTitle title, User proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.celebratedPerson = celebratedPerson;
        this.birthdayYear = birthdayYear;
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
                "Personne célébrée : " + celebratedPerson.name(),
                "Age : " + (LocalDateTime.now().getYear() - birthdayYear.year())
        );

        return generateDescription(content, "Anniversaire");
    }
}
