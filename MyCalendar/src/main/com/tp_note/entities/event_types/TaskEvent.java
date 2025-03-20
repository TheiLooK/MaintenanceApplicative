package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.TaskData;
import com.tp_note.entities.primitives.User;

import java.time.LocalDateTime;

public class TaskEvent extends Event {
    private TaskData task;

    public TaskEvent(TaskData task, EventTitle title, User proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.task = task;
    }

    @Override
    public String description() {
        return "";
    }
}
