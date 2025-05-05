package org.example.View;

import org.example.Controller.RegisterMenuController;
import org.example.Model.App;
import org.example.Model.Result;
import org.example.Model.enums.RegisterMenuCommands;
import org.example.Model.enums.Menu;
import org.example.Model.enums.Gender;
import java.util.Scanner;

public class RegisterMenu implements AppMenu {
    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine().trim();
        if (RegisterMenuCommands.REGISTER.matches(input)) {
            handleRegister(input);
        } else if (RegisterMenuCommands.GO_TO_LOGIN_MENU.matches(input)) {
            //Mahshad ino
            //App.setCurrentMenu(Menu.LoginMenu);
            System.out.println("you are now in login menu!");
        }
        else if (RegisterMenuCommands.EXIT.matches(input)) {
            App.setCurrentMenu(Menu.Exit);
        }
        else {
            invalidCommand();
        }
    }
    private void handleRegister(String input) {
        String username = RegisterMenuCommands.REGISTER.getGroup(input, "username");
        String password = RegisterMenuCommands.REGISTER.getGroup(input, "password");
        String email = RegisterMenuCommands.REGISTER.getGroup(input, "email");
        String name = RegisterMenuCommands.REGISTER.getGroup(input, "name");
        String gender = RegisterMenuCommands.REGISTER.getGroup(input, "gender");
        Result result = RegisterMenuController.register(username, password, email, name, Gender.valueOf(gender));
        System.out.println(result.message());
//        if(result.success()) {
//            App.setCurrentMenu(Menu.LoginMenu);
//        }
    }
}
