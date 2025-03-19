package com.tp_note.entities.concrete_actions.menus;

import com.tp_note.entities.ListAction;
import com.tp_note.entities.concrete_actions.display_events.*;

import java.util.ArrayList;

public class DisplayEventMenuAction extends ListAction {
    public DisplayEventMenuAction() {
        super("Menu Gestionnaire d'Événements", new ArrayList<>(java.util.List.of(
                new DisplayEventsAction(),
                new DisplayEventsMonthAction(),
                new DisplayEventsWeekAction(),
                new DisplayEventsDayAction(),
                new DisplayEventsBackAction()
        )));

    }
}
