package com.tp_note.entities.concrete_actions.display_events;

import com.tp_note.entities.Action;
import com.tp_note.entities.concrete_actions.menus.DisplayEventMenuActionList;
import com.tp_note.services.CalendarManager;
import com.tp_note.services.DisplayService;

import java.time.LocalDateTime;

public class DisplayEventsDayAction extends Action {
    private static DisplayEventsDayAction instance;

    private DisplayEventsDayAction() {
        super("Afficher les événements d'un JOUR précis");
    }

    public static DisplayEventsDayAction getInstance() {
        if (instance == null) {
            instance = new DisplayEventsDayAction();
        }
        return instance;
    }

    @Override
    public void perform() {
        String stringDate = DisplayService.getInstance().printInputString("Entrez la date de la réunion (format : jj/mm/aaaa) : ");
        // Si la date n'est pas valide, on demande à l'utilisateur de recommencer (avec jj comrpis entre 01 et 31, mm entre 01 et 12 et aaaa entre 1000 et 9999)
        while (!stringDate.matches("([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([1-9][0-9]{3})")) {
            DisplayService.getInstance().printTexte("La date n'est pas valide, veuillez réessayer");
            stringDate = DisplayService.getInstance().printInputString("Entrez la date de la réunion (format : jj/mm/aaaa) : ");
        }

        LocalDateTime date = LocalDateTime.of(
                Integer.parseInt(stringDate.substring(6)),
                Integer.parseInt(stringDate.substring(3, 5)),
                Integer.parseInt(stringDate.substring(0, 2)),
                0, 0
        );

        CalendarManager.getInstance().eventsDansPeriode(date, date.plusDays(1)).display();

        DisplayService.getInstance().pressEnter();
        DisplayEventMenuActionList.getInstance().perform();
    }
}
