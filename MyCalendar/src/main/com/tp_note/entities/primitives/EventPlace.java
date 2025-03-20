package com.tp_note.entities.primitives;

public record EventPlace(String place) {
    @Override
    public String toString() {
        return place;
    }
}
