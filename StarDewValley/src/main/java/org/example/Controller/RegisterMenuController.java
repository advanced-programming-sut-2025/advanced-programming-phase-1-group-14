package org.example.Controllers;

import org.example.Model.App;
import org.example.Model.Result;
import org.example.Model.User;
import org.example.Model.enums.Gender;
import org.example.Model.enums.RegisterMenuCommands;

public class RegisterMenuController {

    public static Result register(String username, String password, String email, String nickname, Gender gender) {
        if(!RegisterMenuCommands.USERNAME.matches(username)) {
            return new Result(false, "username format is invalid!");
        }
        //inja kar ba file bayad anjam beshe:
//        else if(App.getUserByUsername(username) != null) {
//            return new Result(false, "this username is already taken!");
//        }
        else if(!RegisterMenuCommands.PASSWORD.matches(password)) {
            return new Result(false, "password format is invalid!");
        }
        else if(!validateEmail(email)) {
            return new Result(false, "email format is invalid!");

        }
        App.addUser(new User(username, nickname, email, password, gender));
        return new Result(true, "user registered successfully.you are now in login menu!");
    }
    private static boolean validateEmail(String email) {
        if(!RegisterMenuCommands.EMAIL.matches(email)) {
            return false;
        }
//        String user = RegisterMenuCommands.EMAIL.getGroup(email, "email");
//        if(!RegisterMenuCommands.USERNAME.matches(user)) {
//            return false;
//        }
        //no need for this. regex can handle it.
        return true;
    }
}