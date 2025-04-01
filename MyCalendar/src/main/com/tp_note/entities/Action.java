package com.tp_note.entities;

import lombok.Getter;

@Getter
public abstract class Action {
    protected String name;

    protected Action(String name) {
        this.name = name;
    }

    public abstract void perform();
}
