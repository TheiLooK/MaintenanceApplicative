package com.tp_note;

import com.tp_note.entities.Event;
import com.tp_note.entities.event_types.MeetingEvent;
import com.tp_note.entities.lists.EventList;
import com.tp_note.entities.lists.UserList;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventPlace;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.User;
import com.tp_note.exceptions.auth.LogInException;
import com.tp_note.exceptions.auth.register.UserAlreadyExistsException;
import com.tp_note.exceptions.events.DeleteEventException;
import com.tp_note.services.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EventTest {
    @Test
    void testRemoveEvent() throws DeleteEventException, LogInException, UserAlreadyExistsException {
        AuthService.getInstance().register("Alice", "jaimebob");
        AuthService.getInstance().register("Bob", "jaimealice");

        EventList eventList = new EventList();
        Event event = new MeetingEvent(
                new UserList("Alice,Bob"),
                new EventPlace("Salle 105"),
                new EventTitle("Réunion de projet"),
                new User("Alice"),
                java.time.LocalDateTime.now(),
                new EventDuration(60)
        );

        AuthService.getInstance().logIn("Alice", "jaimebob");

        eventList.addEvent(event);
        eventList.removeEvent(event.id);

        AuthService.getInstance().logOut();

        Assertions.assertEquals(0, eventList.getEvents().size());
        Assertions.assertFalse(eventList.getEvents().contains(event));
    }
}
