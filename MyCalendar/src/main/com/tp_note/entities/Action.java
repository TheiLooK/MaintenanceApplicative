package com.tp_note.entities;

public abstract class Action {
    protected String name;

    protected Action(String name) {
        this.name = name;
    }

    public abstract void perform();

    public String getName() {
        return name;
    }
}
