package com.tp_note.entities.concrete_actions.manage_events;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.ManageEventMenuActionList;
import com.tp_note.entities.primitives.Id;
import com.tp_note.exceptions.events.DeleteEventException;
import com.tp_note.services.CalendarManager;
import com.tp_note.services.DisplayService;

public class DeleteEventAction extends Action {
    private static DeleteEventAction instance;

    private DeleteEventAction() {
        super("Supprimer un événement");
    }

    public static DeleteEventAction getInstance() {
        if (instance == null) {
            instance = new DeleteEventAction();
        }
        return instance;
    }

    @Override
    public void perform() {
        int id = DisplayService.getInstance().printInputInt("Entrez l'id de l'événement à supprimer : ");
        try {
            CalendarManager.getInstance().removeEvent(new Id(id));
            DisplayService.getInstance().printTexte("L'événement a été supprimé");
        } catch (DeleteEventException e) {
                DisplayService.getInstance().printTexte(e.getMessage());
        }
        ManageEventMenuActionList.getInstance().perform();
    }
}
