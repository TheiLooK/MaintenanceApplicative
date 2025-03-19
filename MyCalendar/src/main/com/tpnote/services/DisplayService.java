package com.tpnote.services;

import java.util.Arrays;
import java.util.Scanner;

public class DisplayService {
    private int longueur;
    private Scanner scanner;

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

    public void printSeparateur() {
        System.out.printf("╠%s╣%n", "═".repeat(longueur));
    }

    public void printEspace() {
        System.out.printf("║%s║%n", " ".repeat(longueur));
    }

    public void printGrandTitre(String element) {
        printTitre(element);
        printSeparateur();
    }

    public void pringMultipleLines(String element) {
        Arrays.stream(element.split("\n")).forEach(this::printTexte);
    }

    private void ajusterLongueurSiNecessaire(String element) {
        int minLength = element.length() + 2;
        if (longueur < minLength) {
            System.out.printf("/!\\ Augmentez la taille de l'affichage d'au moins %d /!\\%n", (minLength - longueur));
            longueur = minLength;
        }
    }

    public
}
