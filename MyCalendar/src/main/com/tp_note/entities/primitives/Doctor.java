package com.tp_note.entities.primitives;

import lombok.Getter;

@Getter
public class Doctor {
    private final String name;
    private final String speciality;

    public Doctor(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return name + " (" + speciality + ")";
    }
}
