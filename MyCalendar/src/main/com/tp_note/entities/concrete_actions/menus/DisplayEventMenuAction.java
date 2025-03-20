package com.tp_note.entities.concrete_actions.menus;

import com.tp_note.entities.lists.ListAction;
import com.tp_note.entities.concrete_actions.display_events.*;

import java.util.ArrayList;

public class DisplayEventMenuAction extends ListAction {
    private static DisplayEventMenuAction instance;

    private DisplayEventMenuAction() {
        super("Menu de visualisation d'Événements", new ArrayList<>(java.util.List.of(
                DisplayEventsAction.getInstance(),
                DisplayEventsMonthAction.getInstance(),
                DisplayEventsWeekAction.getInstance(),
                DisplayEventsDayAction.getInstance(),
                DisplayEventsBackAction.getInstance()
        )));
    }

    public static DisplayEventMenuAction getInstance() {
        if (instance == null) {
            instance = new DisplayEventMenuAction();
        }
        return instance;
    }
}
