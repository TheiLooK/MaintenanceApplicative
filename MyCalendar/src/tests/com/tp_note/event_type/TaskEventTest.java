package com.tp_note.event_type;

import com.tp_note.entities.Event;
import com.tp_note.entities.event_types.TaskEvent;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.TaskData;
import com.tp_note.entities.primitives.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class TaskEventTest {
    @Test
    void testDescription() {
        Event taskEvent = new TaskEvent(
                new TaskData("Complete the report"),
                new EventTitle("Task Event"),
                new User("Alice"),
                LocalDateTime.of(2023, 10, 10, 10, 0),
                new EventDuration(120)
        );

        taskEvent.setId(-10);

        String expectedDescription = """
                ┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
                │ ============================================================ Tâche ============================================================= │
                │ Id : -10                                                                                                                         │
                │ Titre : Task Event                                                                                                               │
                │ Propriétaire : Alice                                                                                                             │
                │ Date : 2023-10-10                                                                                                                │
                │ Heure : 10:00                                                                                                                    │
                │ Durée : 120 minutes                                                                                                              │
                │ Tâche : Complete the report                                                                                                      │
                │ Statut : Non terminé                                                                                                             │
                └──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
                """;

        Assertions.assertEquals(expectedDescription, taskEvent.description());
    }

    @Test
    void testIsInPeriod() {
        Event taskEvent = new TaskEvent(
                new TaskData("Complete the report"),
                new EventTitle("Task Event"),
                new User("Alice"),
                LocalDateTime.of(2023, 10, 10, 10, 0),
                new EventDuration(120)
        );

        Assertions.assertTrue(taskEvent.isInPeriod(
                LocalDateTime.of(2023, 10, 9, 0, 0),
                LocalDateTime.of(2023, 10, 11, 0, 0)
        ));

        Assertions.assertFalse(taskEvent.isInPeriod(
                LocalDateTime.of(2023, 10, 11, 0, 0),
                LocalDateTime.of(2023, 10, 12, 0, 0)
        ));
    }

    @Test
    void testHasAccess() {
        Event taskEvent = new TaskEvent(
                new TaskData("Complete the report"),
                new EventTitle("Task Event"),
                new User("Alice"),
                LocalDateTime.of(2023, 10, 10, 10, 0),
                new EventDuration(120)
        );

        Assertions.assertTrue(taskEvent.hasAccess(new User("Alice")));
        Assertions.assertFalse(taskEvent.hasAccess(new User("Bob")));
    }
}