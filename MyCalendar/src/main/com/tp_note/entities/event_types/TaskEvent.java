package com.tp_note.entities.event_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.TaskData;
import com.tp_note.entities.primitives.User;

import java.time.LocalDateTime;
import java.util.List;

public class TaskEvent extends Event {
    private TaskData task;

    public TaskEvent(TaskData task, EventTitle title, User proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.task = task;
    }

    @Override
    public String description() {
        List<String> content = List.of(
                "Titre : " + title.title(),
                "Propriétaire : " + proprietaire.name(),
                "Date : " + dateDebut.toLocalDate(),
                "Heure : " + dateDebut.toLocalTime().toString().substring(0, 5),
                "Durée : " + dureeMinutes.duration() + " minutes",
                "Tâche : " + task.getDescription(),
                "Statut : " + (task.isDone() ? "Terminé" : "Non terminé")
        );

        return generateDescription(content, "Tâche");
    }
}
