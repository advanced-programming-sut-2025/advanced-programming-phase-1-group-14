package org.example.Model.enums;

import java.util.Scanner;

public enum Menu {
    RegisterMenu(new RegisterMenu());

    public void checkCommand(Scanner scanner){
        this.menu.check(scanner);
    }
}