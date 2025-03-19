package com.tpnote.entities.primitives.event_type;

import com.tpnote.entities.enums.EventTypeEnum;
import com.tpnote.entities.primitives.EventType;

public class Periodique extends EventType {
    public final int frequenceJours;

    public Periodique(int frequenceJours) {
        super(EventTypeEnum.PERIODIQUE);
        this.frequenceJours = frequenceJours;
    }
}
