package org.example.View;

import org.example.Model.enums.Menu;
import org.example.Model.App;

import java.util.Scanner;

public class AppView {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Stardew valley! Please enter your command.");
        do {
            App.getCurrentMenu().checkCommand(scanner);
        } while (App.getCurrentMenu() != Menu.Exit);
    }
}
