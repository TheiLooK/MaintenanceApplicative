package com.tp_note.entities.primitives;

public record MeetingEventPlace(String place) {
    @Override
    public String toString() {
        return place;
    }
}
