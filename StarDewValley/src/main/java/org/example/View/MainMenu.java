package org.example.View;

import org.example.Model.App;
import org.example.Model.enums.MainMenuCommands;
import org.example.Model.enums.Menu;

import java.util.Scanner;

public class MainMenu implements AppMenu{
    @Override
    public void check(String input) {
        //String input = scanner.nextLine().trim();
        //System.out.println("DEBUG: input received!");
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
            System.out.println("User successfully logged out. You are now in Login menu.");
        } else if (MainMenuCommands.SHOWCURRENTMENU.matches(input)) {
            System.out.println("Main Menu");
        } else {
            invalidCommand();
        }
    }
}

