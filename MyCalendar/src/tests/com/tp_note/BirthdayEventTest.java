package com.tp_note;

import com.tp_note.entities.Event;
import com.tp_note.entities.event_types.BirthdayEvent;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;
import com.tp_note.entities.primitives.BirthdayYear;
import com.tp_note.exceptions.entities.BirthdayYearAfterTodayException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class BirthdayEventTest {
    @Test
    void testDescription() {
        Event birthdayEvent = new BirthdayEvent(
                new User("John"),
                new BirthdayYear(2021),
                new EventTitle("Anniversaire de John"),
                new User("John"),
                LocalDateTime.of(2021, 12, 25, 0, 0),
                new EventDuration(60)
        );

        String expectedDescription = """
                ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
                │ ========================================================= Anniversaire ========================================================= │
                │ Titre : Anniversaire de John                                                                                                     │
                │ Propriétaire : John                                                                                                              │
                │ Date : 2021-12-25                                                                                                                │
                │ Heure : 00:00                                                                                                                    │
                │ Durée : 60 minutes                                                                                                               │
                │ Personne célébrée : John                                                                                                         │
                │ Age : 4                                                                                                                          │
                └──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
                """;



        Assertions.assertEquals(expectedDescription, birthdayEvent.description());
    }

    @Test
    void testIsInPeriod() {
        Event birthdayEvent = new BirthdayEvent(
                new User("John"),
                new BirthdayYear(2021),
                new EventTitle("Anniversaire de John"),
                new User("John"),
                LocalDateTime.of(2021, 12, 25, 0, 0),
                new EventDuration(60)
        );

        Assertions.assertTrue(birthdayEvent.isInPeriod(
                LocalDateTime.of(2021, 12, 24, 0, 0),
                LocalDateTime.of(2021, 12, 26, 0, 0)
        ));

        Assertions.assertFalse(birthdayEvent.isInPeriod(
                LocalDateTime.of(2021, 12, 26, 0, 0),
                LocalDateTime.of(2021, 12, 27, 0, 0)
        ));
    }

    @Test
    void testHasAccess() {
        Event birthdayEvent = new BirthdayEvent(
                new User("John"),
                new BirthdayYear(2021),
                new EventTitle("Anniversaire de John"),
                new User("John"),
                LocalDateTime.of(2021, 12, 25, 0, 0),
                new EventDuration(60)
        );

        Assertions.assertTrue(birthdayEvent.hasAccess(new User("John")));
        Assertions.assertFalse(birthdayEvent.hasAccess(new User("Jane")));
    }

    @Test
    void testYear() {
        Assertions.assertThrows(BirthdayYearAfterTodayException.class, () -> new BirthdayYear(2042));
    }

}
