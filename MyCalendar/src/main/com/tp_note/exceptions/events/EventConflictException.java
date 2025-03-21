package com.tp_note.exceptions.events;

public class EventConflictException extends Exception {
    public EventConflictException() {
        super("Un événement est déjà prévu à cette date.");
    }
}
