package org.example.View;

import org.example.Controllers.RegisterMenuController;
import org.example.Model.App;
import org.example.Model.Result;
import org.example.Model.enums.RegisterMenuCommands;
import org.example.Model.enums.Menu;
import org.example.Model.enums.Gender;
import java.util.Scanner;

public class RegisterMenu implements AppMenu {
    @Override
    public void check(String input) {
        //String input = scanner.nextLine().trim();
        System.out.println("DEBUG: input received!");
        if (RegisterMenuCommands.REGISTER.matches(input)) {
            System.out.println("DEBUG: matched REGISTER!");
            handleRegister(input);
        } else if (RegisterMenuCommands.GO_TO_LOGIN_MENU.matches(input)) {
            App.setCurrentMenu(Menu.LoginMenu);
            System.out.println("you are now in login menu!");
        }
        else if (RegisterMenuCommands.EXIT.matches(input)) {
            System.out.println("DEBUG: matched exit!");
            App.setCurrentMenu(Menu.Exit);
        } else if (RegisterMenuCommands.SHOWCURRENTMENU.matches(input)) {
            System.out.println("Register Menu");
        } else if (RegisterMenuCommands.PICK_QUESTION.matches(input)) {
            System.out.println("DEBUG: matched pick!");
            pickQuestion(input, registerCommand);
        } else {
            invalidCommand();
        }
    }
    String registerCommand;
    private void handleRegister(String input) {
        String username = RegisterMenuCommands.REGISTER.getGroup(input, "username");
        String password = RegisterMenuCommands.REGISTER.getGroup(input, "password");
        String email = RegisterMenuCommands.REGISTER.getGroup(input, "email");
        String name = RegisterMenuCommands.REGISTER.getGroup(input, "name");
        String gender = RegisterMenuCommands.REGISTER.getGroup(input, "gender");
        Result result = RegisterMenuController.register(username, password, email, name, Gender.valueOf(gender));
        System.out.println(result.message());
        registerCommand = input;
    }
    private void pickQuestion(String input, String registerCommand) {
        String username = RegisterMenuCommands.REGISTER.getGroup(registerCommand, "username");
        String password = RegisterMenuCommands.REGISTER.getGroup(registerCommand, "password");
        String email = RegisterMenuCommands.REGISTER.getGroup(registerCommand, "email");
        String name = RegisterMenuCommands.REGISTER.getGroup(registerCommand, "name");
        String gender = RegisterMenuCommands.REGISTER.getGroup(registerCommand, "gender");
        int qnum = Integer.parseInt(RegisterMenuCommands.PICK_QUESTION.getGroup(input, "qnum"));
        String ans = RegisterMenuCommands.PICK_QUESTION.getGroup(input, "answer");
        String ansConfirm = RegisterMenuCommands.PICK_QUESTION.getGroup(input, "answerConfirm");
        Result result = RegisterMenuController.pickSecurityQuestion(username, password, email, name,
                Gender.valueOf(gender), qnum, ans, ansConfirm);
        System.out.println(result.message());
        if(result.success()) {
            App.setCurrentMenu(Menu.LoginMenu);
        }
    }

}
