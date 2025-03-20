package com.tp_note.entities.concrete_actions.manage_events.events_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.manage_events.AddEventAction;
import com.tp_note.entities.event_types.TaskEvent;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.entities.primitives.TaskData;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

import java.time.LocalDateTime;

public class AddTaskAction extends AddEventAction {
    private static AddTaskAction instance;

    private AddTaskAction() {
        super("Ajouter une tâche");
    }

    public static AddTaskAction getInstance() {
        if (instance == null) {
            instance = new AddTaskAction();
        }
        return instance;
    }

    @Override
    public void perform() {
        event = createEvent();
        super.perform();
    }

    @Override
    protected Event createEvent() {
        DisplayService displayService = DisplayService.getInstance();

        displayService.printTexte("Ajout d'une tâche");

        String title = displayService.printInputString("Entrez le titre de la tâche : ");
        LocalDateTime date = displayService.printInputDate();
        int duration = displayService.printInputInt("Entrez la durée de la tâche en minutes : ");

        // Spécification de la tâche :
        String taskDescription = displayService.printInputString("Entrez la description de la tâche : ");

        return new TaskEvent(
            new TaskData(taskDescription),
            new EventTitle(title),
            AuthService.getInstance().getLoggedUser(),
            date,
            new EventDuration(duration)
        );
    }
}