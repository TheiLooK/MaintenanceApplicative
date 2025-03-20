package com.tp_note.entities.lists;

import com.tp_note.entities.Action;
import com.tp_note.services.DisplayService;

import java.util.List;
import java.util.stream.IntStream;

public class ListAction extends Action {
    private final List<Action> actions;

    public ListAction(String name, List<Action> actions) {
        super(name);
        this.actions = actions;
    }

    @Override
    public void DO() {
        afficherActions();
        int choix = DisplayService.getInstance().printInputInt("Votre choix : ");
        // Si le choix est invalide, on redemande le choix
        while (choix < 1 || choix > actions.size()) {
            DisplayService.getInstance().printTexte("Choix invalide");
            choix = DisplayService.getInstance().printInputInt("Votre choix : ");
        }
        actions.get(choix - 1).DO();
    }

    public void afficherActions() {
        DisplayService.getInstance().printEspace();
        DisplayService.getInstance().printSeparateur();
        DisplayService.getInstance().printTitre(name);
        IntStream.range(0, actions.size())
                .mapToObj(i -> String.format("%d - %s", i + 1, actions.get(i).name))
                .forEach(DisplayService.getInstance()::printTexte);
        DisplayService.getInstance().printEspace();
    }
}
