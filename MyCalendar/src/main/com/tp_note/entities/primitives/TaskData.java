package com.tp_note.entities.primitives;

import lombok.Getter;

@Getter
public class TaskData {
    private final String description;
    private boolean isDone ;

    public TaskData(String description) {
        this.description = description;
        this.isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone() {
        isDone = true;
    }

    public void setUndone() {
        isDone = false;
    }
}