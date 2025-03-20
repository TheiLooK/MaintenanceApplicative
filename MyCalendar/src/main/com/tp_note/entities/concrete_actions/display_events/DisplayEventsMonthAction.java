package com.tp_note.entities.concrete_actions.display_events;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.DisplayEventMenuAction;
import com.tp_note.services.AuthService;
import com.tp_note.services.CalendarManager;
import com.tp_note.services.DisplayService;

import java.time.LocalDateTime;

public class DisplayEventsMonthAction extends Action {
    private static DisplayEventsMonthAction instance;

    private DisplayEventsMonthAction() {
        super("Afficher les événements d'un MOIS précis");
    }

    public static DisplayEventsMonthAction getInstance() {
        if (instance == null) {
            instance = new DisplayEventsMonthAction();
        }
        return instance;
    }

    @Override
    public void DO() {
        DisplayService displayService = DisplayService.getInstance();

        int year = displayService.printInputInt("Entrez l'année (AAAA) : ");
        while (year < 0) {
            displayService.printTexte("L'année doit être positive");
            year = displayService.printInputInt("Entrez l'année (AAAA) : ");
        }

        int month = displayService.printInputInt("Entrez le numéro du mois (1-12) : ");
        while (month < 1 || month > 12) {
            displayService.printTexte("Le numéro du mois doit être entre 1 et 12");
            month = displayService.printInputInt("Entrez le numéro du mois (1-12) : ");
        }

        LocalDateTime debut = LocalDateTime.of(year, month, 1, 0, 0);

        DisplayService.getInstance().printTitre("Liste des événements du mois " + month + " :");
        CalendarManager.getInstance().eventsDansPeriode(debut, debut.plusMonths(1)).afficher();

        DisplayService.getInstance().Continue();
        DisplayEventMenuAction.getInstance().DO();
    }
}
