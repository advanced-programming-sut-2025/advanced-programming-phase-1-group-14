package org.example.View;

import org.example.Model.enums.Menu;
import org.example.Model.App;

import java.util.Scanner;

public class AppView {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Stardew valley! Please enter your command.");
        do {
            String input = scanner.nextLine().trim();
            if ((App.getCurrentMenu().equals(Menu.RegisterMenu) || App.getCurrentMenu().equals(Menu.LoginMenu))
            && input.equals("menu exit")) {
                System.out.println("bye");
                System.exit(0);
            }
            if (input.equalsIgnoreCase("printMap")) {
                App.printGameMap();
            } else App.getCurrentMenu().checkCommand(input);
        } while (!App.getCurrentMenu().equals(Menu.Exit));

    }
}

