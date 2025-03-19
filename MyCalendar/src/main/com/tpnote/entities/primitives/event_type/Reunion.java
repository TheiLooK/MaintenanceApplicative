package com.tpnote.entities.primitives.event_type;

import com.tpnote.entities.enums.EventTypeEnum;
import com.tpnote.entities.primitives.EventType;

public class Reunion extends EventType {
    public final String participants;
    public final String lieu;

    public Reunion(String participants, String lieu) {
        super(EventTypeEnum.REUNION);
        this.participants = participants;
        this.lieu = lieu;
    }
}
