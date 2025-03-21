package com.tp_note.entities.concrete_actions.menus;

import com.tp_note.entities.lists.ActionList;
import com.tp_note.entities.concrete_actions.display_events.*;

import java.util.ArrayList;

public class DisplayEventMenuActionList extends ActionList {
    private static DisplayEventMenuActionList instance;

    private DisplayEventMenuActionList() {
        super("Menu de visualisation d'Événements", new ArrayList<>(java.util.List.of(
                DisplayEventsAction.getInstance(),
                DisplayEventsMonthAction.getInstance(),
                DisplayEventsWeekAction.getInstance(),
                DisplayEventsDayAction.getInstance(),
                DisplayTasksAction.getInstance(),
                DisplayEventsBackAction.getInstance()
        )));
    }

    public static DisplayEventMenuActionList getInstance() {
        if (instance == null) {
            instance = new DisplayEventMenuActionList();
        }
        return instance;
    }
}
