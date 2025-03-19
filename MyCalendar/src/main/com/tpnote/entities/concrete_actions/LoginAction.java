package com.tpnote.entities.concrete_actions;

import com.tpnote.entities.Action;
import com.tpnote.services.AuthService;
import com.tpnote.services.DisplayService;

import java.util.Scanner;

public class LoginAction extends Action {
    public LoginAction() {
        super("Login");
    }


    @Override
    public String DO() {
        AuthService authService = AuthService.getInstance();
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur de rentrer son login et son mot de passe
        DisplayService displayService = new DisplayService(50);
        String login = scanner.nextLine();

        System.out.println("Entrez votre mot de passe : ");


    }
}
