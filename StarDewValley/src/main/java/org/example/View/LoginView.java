package org.example.View;

import org.example.Controllers.LoginController;
import org.example.Model.App;
import org.example.Model.Result;
import org.example.Model.User;
import org.example.Model.enums.LoginMenuCommands;
import org.example.Model.enums.Menu;

import java.util.Scanner;

public class LoginView implements AppMenu {
    User pendingUser;
    @Override
    public void check(String input) {
        //String input = scanner.nextLine().trim();
        if (LoginMenuCommands.LOGIN.matches(input)) {
            handleLogin(input);
        } else if (LoginMenuCommands.FORGET_PASSWORD.matches(input)) {
            handleForgetPassword(input);
        } else if (LoginMenuCommands.EXIT.matches(input)) {
            App.setCurrentMenu(Menu.Exit);
        } else if (LoginMenuCommands.ANSWER_SECURITY_QUESTION.matches(input)) {
            String answer = LoginMenuCommands.ANSWER_SECURITY_QUESTION.getGroup(input, "answer");
            if (LoginController.checkSecurityAnswer(pendingUser, answer)) {
                System.out.println("Answer correct! Please reset your password:");
                System.out.println("reset password -p <new> -c <confirm>");
            } else {
                System.out.println("Wrong answer. Returning to login menu.");
                pendingUser = null;
            }
        } else if (LoginMenuCommands.SHOWCURRENTMENU.matches(input)) {
            System.out.println("Login Menu");
        } else if (LoginMenuCommands.RESET_PASSWORD.matches(input)) {
            handleReset(input);
        } else {
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
        User user = App.getUserByUsername(username);
        pendingUser = user;
        if (user == null) {
            System.out.println("username doesn't exist!");
        } else {
            System.out.println("Security question: "
                    + user.getSecurityQuestion().getText());
            System.out.println("Please answer with: answer -a <your answer>");
        }
    }
    private void handleReset(String input) {
        String newPass = LoginMenuCommands.RESET_PASSWORD.getGroup(input, "password");
        String confirm = LoginMenuCommands.RESET_PASSWORD.getGroup(input, "confirm");
        Result res = LoginController.resetPassword(pendingUser, newPass, confirm);
        System.out.println(res.message());
        if (res.success()) {
            App.setLoggedInUser(pendingUser);
            App.setCurrentMenu(Menu.MainMenu);
        }
        pendingUser = null;
    }
}
