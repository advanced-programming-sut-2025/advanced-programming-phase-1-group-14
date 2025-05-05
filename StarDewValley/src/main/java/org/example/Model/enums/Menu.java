package org.example.Model.enums;

import org.example.View.*;

import java.util.Scanner;

public enum Menu {
    RegisterMenu(new RegisterMenu()),
    Exit(new ExitMenu());
    private final AppMenu menu;
    Menu(AppMenu menu){
        this.menu = menu;
    }
    public void checkCommand(Scanner scanner){
        this.menu.check(scanner);
    }
}