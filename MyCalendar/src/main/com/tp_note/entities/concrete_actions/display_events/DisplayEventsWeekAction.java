package com.tp_note.entities.concrete_actions.display_events;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.DisplayEventMenuAction;
import com.tp_note.services.AuthService;
import com.tp_note.services.CalendarManager;
import com.tp_note.services.DisplayService;

import java.time.LocalDateTime;

public class DisplayEventsWeekAction extends Action {
    private static DisplayEventsWeekAction instance;

    private DisplayEventsWeekAction() {
        super("Afficher les événements d'une SEMAINE précise");
    }

    public static DisplayEventsWeekAction getInstance() {
        if (instance == null) {
            instance = new DisplayEventsWeekAction();
        }
        return instance;
    }

    @Override
    public void DO() {
        DisplayService displayService = DisplayService.getInstance();
        CalendarManager calendarManager = AuthService.getInstance().getLoggedUser().calendar();

        int year = displayService.printInputInt("Entrez l'année (AAAA) : ");
        while (year < 0) {
            displayService.printTexte("L'année doit être positive");
            year = displayService.printInputInt("Entrez l'année (AAAA) : ");
        }

        int week = displayService.printInputInt("Entrez le numéro de la semaine (1-52) : ");
        while (week < 1 || week > 52) {
            displayService.printTexte("Le numéro de la semaine doit être entre 1 et 52");
            week = displayService.printInputInt("Entrez le numéro de la semaine (1-52) : ");
        }

        LocalDateTime debut = LocalDateTime.of(year, 1, 1, 0, 0).plusWeeks(week - 1);
        LocalDateTime fin = debut.plusWeeks(1);

        DisplayService.getInstance().printTitre("Liste des événements de la semaine " + week + " de l'année " + year + " :");
        calendarManager.eventsDansPeriode(debut, fin).events.stream().map(e -> e.description() + " : " + e.dateDebut).forEach(displayService::printTexte);

        DisplayService.getInstance().Continue();
        DisplayEventMenuAction.getInstance().DO();
    }
}
