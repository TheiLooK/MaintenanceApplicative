package com.tp_note.entities.concrete_actions.manage_events.events_types;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.ManageEventMenuActionList;

public class AddEventBackAction extends Action {
    private static AddEventBackAction instance;

    private AddEventBackAction() {
        super("Retour");
    }

    public static AddEventBackAction getInstance() {
        if (instance == null) {
            instance = new AddEventBackAction();
        }
        return instance;
    }

    @Override
    public void perform() {
        ManageEventMenuActionList.getInstance().perform();
    }

}
