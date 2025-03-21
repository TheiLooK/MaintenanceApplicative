package com.tp_note.entities.concrete_actions.menus;

import com.tp_note.entities.concrete_actions.manage_events.events_types.*;
import com.tp_note.entities.lists.ActionList;

public class CreateEventMenuActionList extends ActionList {
    private static CreateEventMenuActionList instance;

    private CreateEventMenuActionList() {
        super("Menu Création d'Événements", new java.util.ArrayList<>(java.util.List.of(
                AddRdvPersoAction.getInstance(),
                AddReunionAction.getInstance(),
                AddPeriodiqueAction.getInstance(),
                AddBirthdayAction.getInstance(),
                AddConferenceEventAction.getInstance(),
                AddMedicalAppointmentAction.getInstance(),
                AddTaskAction.getInstance(),
                AddEventBackAction.getInstance()
        )));
    }

    public static CreateEventMenuActionList getInstance() {
        if (instance == null) {
            instance = new CreateEventMenuActionList();
        }
        return instance;
    }
}
