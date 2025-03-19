package com.tpnote.entities.primitives;

import com.tpnote.entities.enums.EventTypeEnum;

public abstract class EventType {
    public final EventTypeEnum type;

    protected EventType(EventTypeEnum type) {
        this.type = type;
    }

    public abstract String toString();
}
