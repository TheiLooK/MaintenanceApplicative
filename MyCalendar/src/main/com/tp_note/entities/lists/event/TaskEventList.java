package com.tp_note.entities.lists.event;

import com.tp_note.entities.event_types.TaskEvent;
import com.tp_note.entities.lists.EventList;
import com.tp_note.services.DisplayService;

import java.util.List;

public class TaskEventList extends EventList {
    private final List<TaskEvent> events;

    public TaskEventList(List<TaskEvent> events) {
        this.events = events;
    }

    public void checkTaskEvent(int id) {
        events.stream().filter(e -> e.id.value() == id)
                .findFirst().ifPresent(TaskEvent::checkTask);
    }

    public boolean isTaskEventExist(int id) {
        return events.stream().anyMatch(e -> e.id.value() == id);
    }

    @Override
    public void display() {
        events.forEach(e -> DisplayService.getInstance().printMultipleLines(e.description()));
    }
}
