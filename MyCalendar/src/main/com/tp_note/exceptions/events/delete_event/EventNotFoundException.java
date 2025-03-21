package com.tp_note.exceptions.events.delete_event;

import com.tp_note.exceptions.events.DeleteEventException;

public class EventNotFoundException extends DeleteEventException {
    public EventNotFoundException() {
        super("L'événement n'a pas été trouvé.");
    }
}
