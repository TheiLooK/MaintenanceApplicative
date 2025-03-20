package com.tp_note.entities.lists;

import com.tp_note.entities.Action;
import com.tp_note.services.DisplayService;

import java.util.List;
import java.util.stream.IntStream;

public class ActionList extends Action {
    private final List<Action> actions;

    public ActionList(String name, List<Action> actions) {
        super(name);
        this.actions = actions;
    }

    @Override
    public void perform() {
        displayActions();
        int choice = DisplayService.getInstance().printInputInt("Votre choix : ");
        // Si le choix est invalide, on redemande le choix
        while (choice < 1 || choice > actions.size()) {
            DisplayService.getInstance().printTexte("Choix invalide");
            choice = DisplayService.getInstance().printInputInt("Votre choix : ");
        }
        actions.get(choice - 1).perform();
    }

    public void displayActions() {
        DisplayService.getInstance().printEspace();
        DisplayService.getInstance().printSpacer();
        DisplayService.getInstance().printTitre(name);
        IntStream.range(0, actions.size())
                .mapToObj(i -> String.format("%d - %s", i + 1, actions.get(i).getName()))
                .forEach(DisplayService.getInstance()::printTexte);
        DisplayService.getInstance().printEspace();
    }
}
