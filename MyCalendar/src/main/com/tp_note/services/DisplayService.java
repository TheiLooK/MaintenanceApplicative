package com.tp_note.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class DisplayService {
    private int longueur;
    private final Scanner scanner;

    private static DisplayService instance = null;

    private DisplayService() {
        this.longueur = 134;
        this.scanner = new Scanner(System.in);
    }

    public static DisplayService getInstance() {
        if (instance == null) {
            instance = new DisplayService();
        }
        return instance;
    }

    public void printHaut() {
        System.out.printf("╔%s╗%n", "═".repeat(longueur));
    }

    public void printBas() {
        System.out.printf("╚%s╝%n", "═".repeat(longueur));
    }

    public void printTitre(String element) {
        ajusterLongueurSiNecessaire(element);
        int padding = (longueur - element.length() - 2) / 2;
        String titre = String.format("║%s[%s]%s║", " ".repeat(padding), element, " ".repeat(padding + (longueur % 2)));
        System.out.println(titre);
        printEspace();
    }

    public void printTexte(String element) {
        ajusterLongueurSiNecessaire(element);
        String texte = String.format("║ %s%s ║", element, " ".repeat(longueur - element.length() - 2));
        System.out.println(texte);
    }

    public void printSpacer() {
        System.out.printf("╠%s╣%n", "═".repeat(longueur));
    }

    public void printEspace() {
        System.out.printf("║%s║%n", " ".repeat(longueur));
    }

    public void printMultipleLines(String element) {
        Arrays.stream(element.split("\n")).forEach(this::printTexte);
    }

    private void ajusterLongueurSiNecessaire(String element) {
        int minLength = element.length() + 2;
        if (longueur < minLength) {
            System.out.printf("/!\\ Augmentez la taille de l'affichage d'au moins %d /!\\%n", (minLength - longueur));
            longueur = minLength;
        }
    }

    public String printInputString(String message) {
        ajusterLongueurSiNecessaire(message);
        String texte = String.format("║ %s", message);
        System.out.print(texte);
        return scanner.nextLine();
    }

    public int printInputInt(String message) {
        ajusterLongueurSiNecessaire(message);
        String texte = String.format("║ %s", message);
        System.out.print(texte);

        int value;
        try {
            value = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            scanner.nextLine();
            this.printTexte("La valeur entrée n'est pas un nombre entier");
            return this.printInputInt(message);
        }

        return value;
    }

    public LocalDateTime printInputDate() {
        String date = this.printInputString("Entrez la date de l'événement (format : jj/mm/aaaa) : ");
        // Si la date n'est pas valide, on demande à l'utilisateur de recommencer (avec jj comrpis entre 01 et 31, mm entre 01 et 12 et aaaa entre 1000 et 9999)
        while (!date.matches("([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([1-9][0-9]{3})")) {
            this.printTexte("La date n'est pas valide, veuillez réessayer");
            date = this.printInputString("Entrez la date de l'événement (format : jj/mm/aaaa) : ");
        }

        String heure = this.printInputString("Entrez l'heure de l'événement (format : hh:mm) : ");
        // Si l'heure n'est pas valide, on demande à l'utilisateur de recommencer (avec hh compris entre 00 et 23 et mm entre 00 et 59)
        while (!heure.matches("([0-1][0-9]|2[0-3]):[0-5][0-9]")) {
            this.printTexte("L'heure n'est pas valide, veuillez réessayer");
            heure = this.printInputString("Entrez l'heure de l'événement (format : hh:mm) : ");
        }

        return LocalDateTime.of(
                Integer.parseInt(date.split("/")[2]),
                Integer.parseInt(date.split("/")[1]),
                Integer.parseInt(date.split("/")[0]),
                Integer.parseInt(heure.split(":")[0]),
                Integer.parseInt(heure.split(":")[1])
        );
    }

    public void pressEnter() {
        System.out.print("║ Appuyez sur Entrée pour continuer : ");
        scanner.nextLine();
    }
}
