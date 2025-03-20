package com.tp_note.entities.concrete_actions;

import com.tp_note.entities.Action;
import com.tp_note.services.DisplayService;

public class ExitAction extends Action {
    private static ExitAction instance;

    private ExitAction() {
        super("Quitter l'application");
    }

    public static ExitAction getInstance() {
        if (instance == null) {
            instance = new ExitAction();
        }
        return instance;
    }

    @Override
    public void DO() {
        DisplayService.getInstance().printTexte("Fermeture de l'application...");
        DisplayService.getInstance().printBas();
        System.exit(0);
    }
}
