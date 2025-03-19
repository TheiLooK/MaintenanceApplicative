package com.tp_note.entities.primitives;

import com.tp_note.services.CalendarManager;

public record User(String name, CalendarManager calendar) {
    public User(String name) {
        this(name, new CalendarManager());
    }
}
