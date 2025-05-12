package org.example.Controllers;

import org.example.Model.App;
import org.example.Model.enums.Menu;

public abstract class BaseMenuController {
    //protected Menu currentMenu = Menu.RegisterMenu;  // یا از App.getCurrentMenu()
    protected Menu currentMenu = App.getCurrentMenu();
    public final void handleInput(String input) {
        if (processCommonCommands(input)) {
            return;
        }
        handleSpecific(input);
    }


    private boolean processCommonCommands(String input) {
        if (input.equals("show current menu")) {
            System.out.println("Current menu: " + currentMenu);
            return true;
        }

        if (input.matches("menu\\s+exit")) {
            if (currentMenu == Menu.RegisterMenu || currentMenu == Menu.LoginMenu) {
                System.out.println("Exiting application. Bye!");
                System.exit(0);
            } else {
                currentMenu = Menu.MainMenu;
                System.out.println("Returned to Main Menu.");
            }
            return true;
        }

        if (input.matches("menu\\s+enter\\s+\\S+")) {
            String[] parts = input.split("\\s+");
            String targetName = parts[2];
            try {
                Menu target = Menu.valueOf(targetName);
                if (App.canEnter(currentMenu, target)) {
                    currentMenu = target;
                    System.out.println("Entered " + target + ".");
                    App.setCurrentMenu(currentMenu);
                } else {
                    System.out.printf("Cannot enter %s from %s!%n", target, currentMenu);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown menu: " + targetName);
            }
            return true;
        }

        return false;
    }

    protected abstract void handleSpecific(String input);
}

