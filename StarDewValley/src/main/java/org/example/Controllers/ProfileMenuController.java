package org.example.Controllers;

import org.example.Model.App;
import org.example.Model.Result;
import org.example.Model.enums.RegisterMenuCommands;

public class ProfileMenuController {
    public static Result changeUsername(String username) {
        if (!RegisterMenuCommands.USERNAME.matches(username)) {
            return new Result(false, "invalid username!");
        } else if (username.equals(App.getLoggedInUser().getUsername())) {
            return new Result(false, "please choose a NEW username!");
        } else {
            return new Result(true, "username successfully changed!");
        }
    }
    public static Result changePassword(String password, String confirm) {
        if (!RegisterMenuCommands.PASSWORD.matches(password)) {
            return new Result(false, "invalid password!");
        } else if (password.equals(App.getLoggedInUser().getPassword())) {
            return new Result(false, "please choose a NEW password!");
        } else if (!password.equals(confirm)) {
            return new Result(false, "password confirm is wrong!");
        } else return new Result(true, "password successfully changed!");
    }
    public static Result changeNickname(String nickname) {
        if (!RegisterMenuCommands.NICKNAME.matches(nickname)) {
            return new Result(false, "invalid nickname!");
        } else if (nickname.equals(App.getLoggedInUser().getNickname())) {
            return new Result(false, "please choose a NEW nickname!");
        } else return new Result(true, "nickname successfully changed!");
    }
    public static Result changeEmail(String email) {
        if (!RegisterMenuCommands.EMAIL.matches(email)) {
            return new Result(false, "invalid email!");
        } else if (email.equals(App.getLoggedInUser().getEmail())) {
            return new Result(false, "please choose a NEW email!");
        } else return new Result(true, "email successfully changed!");
    }
    public static void showInfo() {
        System.out.println("username: " + App.getLoggedInUser().getUsername());
        System.out.println("nickname: " + App.getLoggedInUser().getNickname());
        System.out.println("highest money: " + App.getLoggedInUser().getHighestMoney());
        System.out.println("games: " + App.getLoggedInUser().getGameNumbers());
    }

}
