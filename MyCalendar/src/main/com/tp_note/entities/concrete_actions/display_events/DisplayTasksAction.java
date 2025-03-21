package com.tp_note.entities.concrete_actions.display_events;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.DisplayEventMenuActionList;
import com.tp_note.services.CalendarManager;
import com.tp_note.services.DisplayService;

public class DisplayTasksAction extends Action {
    private static DisplayTasksAction instance;

    private DisplayTasksAction() {
        super("Afficher les tâches");
    }

    public static DisplayTasksAction getInstance() {
        if (instance == null) {
            instance = new DisplayTasksAction();
        }
        return instance;
    }

    @Override
    public void perform() {
        DisplayService.getInstance().printTexte("Liste des tâches : ");
        CalendarManager.getInstance().getTasks().display();
        DisplayService.getInstance().pressEnter();
        DisplayEventMenuActionList.getInstance().perform();
    }
}
