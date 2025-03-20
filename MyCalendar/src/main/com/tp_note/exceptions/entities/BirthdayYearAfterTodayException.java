package com.tp_note.exceptions.entities;

public class BirthdayYearAfterTodayException extends Exception {
    public BirthdayYearAfterTodayException() {
        super("L'année de naissance ne peut pas être après l'année actuelle.");
    }
}
