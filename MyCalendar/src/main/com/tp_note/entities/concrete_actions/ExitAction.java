package com.tp_note.entities.concrete_actions;

import com.tp_note.entities.Action;
import com.tp_note.services.DisplayService;

public class ExitAction extends Action {
    public ExitAction() {
        super("Exit");
    }

    @Override
    public void DO() {
        DisplayService.getInstance().printTexte("Exiting...");
        DisplayService.getInstance().printBas();
        System.exit(0);
    }
}
