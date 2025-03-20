package com.tp_note.entities.primitives;

public class Doctor {
    private final String name;
    private final String speciality;

    public Doctor(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return name + " (" + speciality + ")";
    }
}
