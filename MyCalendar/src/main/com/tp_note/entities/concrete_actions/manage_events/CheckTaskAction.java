package com.tp_note.entities.concrete_actions.manage_events;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.ManageEventMenuActionList;
import com.tp_note.entities.lists.event.TaskEventList;
import com.tp_note.services.CalendarManager;
import com.tp_note.services.DisplayService;

public class CheckTaskAction extends Action {
    private static CheckTaskAction instance;

    private CheckTaskAction() {
        super("Valider une tâche");
    }

    public static CheckTaskAction getInstance() {
        if (instance == null) {
            instance = new CheckTaskAction();
        }
        return instance;
    }

    @Override
    public void perform() {
        DisplayService.getInstance().printTexte("Valider une tâche");

        // Afficher les tâches
        DisplayService.getInstance().printTexte("Liste des tâches : ");
        TaskEventList tasks = CalendarManager.getInstance().getTasks();
        tasks.display();

        // Demander l'index de la tâche à valider
        int index = DisplayService.getInstance().printInputInt("Entrez l'index de la tâche à valider : ");
        // Vérifier que l'index est valide
        while (!tasks.isTaskEventExist(index)) {
            DisplayService.getInstance().printTexte("L'index entré n'est pas une tâche valide.");
            index = DisplayService.getInstance().printInputInt("Entrez l'index de la tâche à valider : ");
        }

        // Valider la tâche
        tasks.checkTaskEvent(index);

        DisplayService.getInstance().printTexte("La tâche a été validée.");

        ManageEventMenuActionList.getInstance().perform();
    }
}
