package com.tpnote.entities;

public abstract class Action {
    public String name;

    protected Action(String name) {
        this.name = name;
    }

    public abstract String DO();
}
