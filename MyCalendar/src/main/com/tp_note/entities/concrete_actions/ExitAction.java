package com.tp_note.entities.concrete_actions;

import com.tp_note.entities.Action;
import com.tp_note.services.DisplayService;

public class ExitAction extends Action {
    public ExitAction() {
        super("Quitter l'application");
    }

    @Override
    public void perform() {
        DisplayService.getInstance().printTexte("Fermeture de l'application...");
        DisplayService.getInstance().printBas();
        System.exit(0);
    }
}
