package org.example.View;

import org.example.Controllers.LoginController;
import org.example.Model.App;
import org.example.Model.Result;
import org.example.Model.enums.LoginMenuCommands;
import org.example.Model.enums.Menu;

import java.util.Scanner;

public class LoginView implements AppMenu {
    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine().trim();
        if (LoginMenuCommands.LOGIN.matches(input)) {
            handleLogin(input);
        } else if (LoginMenuCommands.FORGET_PASSWORD.matches(input)) {
            handleForgetPassword(input);
        } else if (LoginMenuCommands.EXIT.matches(input)) {
            App.setCurrentMenu(Menu.Exit);
        }/* else if (LoginMenuCommands.ANSWER_SECURITY_QUESTION.matches(input)) {
            App.setCurrentMenu(Menu.Exit);
        }*/ else {
            invalidCommand();
        }
    }
    private void handleLogin(String input) {
        String username = LoginMenuCommands.LOGIN.getGroup(input, "username");
        String password = LoginMenuCommands.LOGIN.getGroup(input, "password");

        Result loginResult = LoginController.login(username, password);
        System.out.println(loginResult.message());
        if(loginResult.success()) {
            App.setCurrentMenu(Menu.MainMenu);
        }
    }
    private void handleForgetPassword(String input) {
        String username = LoginMenuCommands.FORGET_PASSWORD.getGroup(input, "username");

        Result forgetPasswordResult = LoginController.forgetPassword(username);
        System.out.println(forgetPasswordResult.message());
    }
}