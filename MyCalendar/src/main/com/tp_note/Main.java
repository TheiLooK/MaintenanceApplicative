package com.tp_note;

import com.tp_note.entities.concrete_actions.menus.LoginMenuActionList;
import com.tp_note.exceptions.auth.LogInException;
import com.tp_note.services.DisplayService;

public class Main {
    public static void main(String[] args) throws LogInException {
        DisplayService displayService = DisplayService.getInstance();
        displayService.printHaut();
        displayService.printEspace();
        displayService.printMultipleLines("""
                 ██████╗ █████╗ ██╗     ███████╗███╗   ██╗██████╗  █████╗ ██████╗     ███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗██████╗\s
                ██╔════╝██╔══██╗██║     ██╔════╝████╗  ██║██╔══██╗██╔══██╗██╔══██╗    ████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝██╔══██╗
                ██║     ███████║██║     █████╗  ██╔██╗ ██║██║  ██║███████║██████╔╝    ██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██████╔╝
                ██║     ██╔══██║██║     ██╔══╝  ██║╚██╗██║██║  ██║██╔══██║██╔══██╗    ██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██╔══██╗
                ╚██████╗██║  ██║███████╗███████╗██║ ╚████║██████╔╝██║  ██║██║  ██║    ██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║  ██║
                 ╚═════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═══╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝    ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝
                """);
        displayService.printEspace();
        displayService.printSpacer();

        try {
            DataGenerator.generate();
        }
        catch (Exception e) {
            displayService.printTexte("Erreur lors de la génération des données.");
            displayService.printTexte("Veuillez réessayer.");
            return;
        }

        LoginMenuActionList.getInstance().perform();
    }
}