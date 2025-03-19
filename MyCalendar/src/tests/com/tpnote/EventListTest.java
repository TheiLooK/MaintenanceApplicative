package com.tpnote;

import com.tpnote.entities.Event;
import com.tpnote.entities.primitives.*;
import com.tpnote.entities.event_type.Reunion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

class EventListTest {

    @Test
    void testAddEvent() {
        EventList eventList = new EventList();
        Event event = createSampleEvent();

        eventList.addEvent(event);

        assertEquals(1, eventList.getEvents().size());
        assertTrue(eventList.getEvents().contains(event));
    }

    @Test
    void testRemoveEvent() {
        EventList eventList = new EventList();
        Event event = createSampleEvent();

        eventList.addEvent(event);
        eventList.removeEvent(event);

        assertEquals(0, eventList.getEvents().size());
        assertFalse(eventList.getEvents().contains(event));
    }

    @Test
    void testGetEvents() {
        EventList eventList = new EventList();
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
        EventOwner owner = new EventOwner(new User("Alice"));
        EventDuration duration = new EventDuration(60);

        return new Reunion("Alice, Bob", "Salle 123", title, owner, LocalDateTime.now(), duration);
    }
}

