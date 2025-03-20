package com.tp_note.event_type;

import com.tp_note.entities.Event;
import com.tp_note.entities.event_types.ConferenceEvent;
import com.tp_note.entities.lists.UserList;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventPlace;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class ConferenceEventTest {
    @Test
    void testDescription() {
        UserList speakers = new UserList("Dr. Smith,Prof. Johnson");
        Event conferenceEvent = new ConferenceEvent(
                speakers,
                new EventPlace("Conference Hall A"),
                new EventTitle("Tech Conference"),
                new User("Alice"),
                LocalDateTime.of(2023, 10, 10, 10, 0),
                new EventDuration(180)
        );

        String expectedDescription = """
                ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
                │ ======================================================= Tech Conference ======================================================== │
                │ Titre : Tech Conference                                                                                                          │
                │ Propriétaire : Alice                                                                                                             │
                │ Date : 2023-10-10                                                                                                                │
                │ Heure : 10:00                                                                                                                    │
                │ Durée : 180 minutes                                                                                                              │
                │ Intervenants : Dr. Smith, Prof. Johnson                                                                                          │
                │ Lieu : Conference Hall A                                                                                                         │
                └──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
                """;

        Assertions.assertEquals(expectedDescription, conferenceEvent.description());
    }

    @Test
    void testIsInPeriod() {
        UserList speakers = new UserList("Dr. Smith,Prof. Johnson");
        Event conferenceEvent = new ConferenceEvent(
                speakers,
                new EventPlace("Conference Hall A"),
                new EventTitle("Tech Conference"),
                new User("Alice"),
                LocalDateTime.of(2023, 10, 10, 10, 0),
                new EventDuration(180)
        );

        Assertions.assertTrue(conferenceEvent.isInPeriod(
                LocalDateTime.of(2023, 10, 9, 0, 0),
                LocalDateTime.of(2023, 10, 11, 0, 0)
        ));

        Assertions.assertFalse(conferenceEvent.isInPeriod(
                LocalDateTime.of(2023, 10, 11, 0, 0),
                LocalDateTime.of(2023, 10, 12, 0, 0)
        ));
    }

    @Test
    void testHasAccess() {
        UserList speakers = new UserList("Dr. Smith,Prof. Johnson");
        Event conferenceEvent = new ConferenceEvent(
                speakers,
                new EventPlace("Conference Hall A"),
                new EventTitle("Tech Conference"),
                new User("Alice"),
                LocalDateTime.of(2023, 10, 10, 10, 0),
                new EventDuration(180)
        );

        Assertions.assertTrue(conferenceEvent.hasAccess(new User("Alice")));
        Assertions.assertFalse(conferenceEvent.hasAccess(new User("Bob")));
    }
}