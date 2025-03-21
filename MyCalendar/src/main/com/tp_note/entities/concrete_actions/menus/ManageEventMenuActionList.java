package com.tp_note.entities.concrete_actions.menus;

import com.tp_note.entities.concrete_actions.manage_events.CheckTaskAction;
import com.tp_note.entities.concrete_actions.manage_events.DeleteEventAction;
import com.tp_note.entities.lists.ActionList;
import com.tp_note.entities.concrete_actions.auth.LogoutAction;

public class ManageEventMenuActionList extends ActionList {
    private static ManageEventMenuActionList instance;

    private ManageEventMenuActionList() {
        super("Menu Gestionnaire d'Événements", new java.util.ArrayList<>(java.util.List.of(
                DisplayEventMenuActionList.getInstance(),
                CreateEventMenuActionList.getInstance(),
                DeleteEventAction.getInstance(),
                CheckTaskAction.getInstance(),
                LogoutAction.getInstance()
        )));
    }

    public static ManageEventMenuActionList getInstance() {
        if (instance == null) {
            instance = new ManageEventMenuActionList();
        }
        return instance;
    }
}
