package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.lists.UserList;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventPlace;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class ConferenceEvent extends Event {
    private UserList speakers;
    private EventPlace place;

    public ConferenceEvent(UserList speakers, EventPlace place, EventTitle title, User proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.speakers = speakers;
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
                "Intervenants : " + speakers,
                "Lieu : " + place
        );

        return generateDescription(content, "Conférence");
    }
}
