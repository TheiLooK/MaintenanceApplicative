package com.tp_note.exceptions.events.delete_event;

import com.tp_note.exceptions.events.DeleteEventException;

public class EventMustBeOwnerToDeleteException extends DeleteEventException {
    public EventMustBeOwnerToDeleteException() {
        super("Vous devez être le propriétaire de l'événement pour le supprimer.");
    }
}
