package org.example.Model.enums;

import org.example.View.*;

import java.util.Scanner;

public enum Menu {
    RegisterMenu(new RegisterMenu()),
    LoginMenu(new LoginView()),
    MainMenu(new MainMenu()),
    ProfileMenu(new ProfileMenu()),
    GameMenu(new GameMenu()),
    AvatarMenu(new AvatarMenu()),
    Exit(new ExitMenu());
    private final AppMenu menu;
    Menu(AppMenu menu){
        this.menu = menu;
    };

    public void checkCommand(Scanner scanner){
        this.menu.check(scanner);
    }
}
