package org.example.View;

import org.example.Model.App;
import org.example.Model.enums.MainMenuCommands;
import org.example.Model.enums.Menu;

import java.util.Scanner;

public class MainMenu implements AppMenu{
    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine().trim();
        if (MainMenuCommands.ENTER_GAME_MENU.matches(input)) {
            App.setCurrentMenu(Menu.GameMenu);
            System.out.println("you are now in game menu.");
        } else if (MainMenuCommands.ENTER_PROFILE_MENU.matches(input)) {
            App.setCurrentMenu(Menu.ProfileMenu);
            System.out.println("you are now in profile menu.");
        } else if (MainMenuCommands.ENTER_AVATAR_MENU.matches(input)) {
            App.setCurrentMenu(Menu.AvatarMenu);
            System.out.println("you are now in avatar menu.");
        } else if (MainMenuCommands.LOGOUT.matches(input)) {
            App.setCurrentMenu(Menu.LoginMenu);
            App.setLoggedInUser(null);
        } else {
            invalidCommand();
        }
    }
}

