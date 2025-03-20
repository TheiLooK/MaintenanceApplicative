package com.tp_note;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.*;
import com.tp_note.entities.event_types.Reunion;
import com.tp_note.entities.lists.ListEvent;
import com.tp_note.entities.lists.ListUser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

class EventListTest {

    @Test
    void testAddEvent() {
        ListEvent eventList = new ListEvent();
        Event event = createSampleEvent();

        eventList.addEvent(event);

        assertEquals(1, eventList.getEvents().size());
        assertTrue(eventList.getEvents().contains(event));
    }

    @Test
    void testRemoveEvent() {
        ListEvent eventList = new ListEvent();
        Event event = createSampleEvent();

        eventList.addEvent(event);
        eventList.removeEvent(event);

        assertEquals(0, eventList.getEvents().size());
        assertFalse(eventList.getEvents().contains(event));
    }

    @Test
    void testGetEvents() {
        ListEvent eventList = new ListEvent();
        Event event1 = createSampleEvent();
        Event event2 = createSampleEvent();

        eventList.addEvent(event1);
        eventList.addEvent(event2);

        List<Event> events = eventList.getEvents();
        assertEquals(2, events.size());
        assertTrue(events.contains(event1));
        assertTrue(events.contains(event2));
    }

    // Méthode utilitaire pour créer un événement
    private Event createSampleEvent() {
        EventTitle title = new EventTitle("Réunion de projet");
        User owner = new User("Alice");
        EventDuration duration = new EventDuration(60);

        return new Reunion(new ListUser("Alice,Bob"), "Salle 123", title, owner, LocalDateTime.now(), duration);
    }
}

