package org.example.Controllers;

import org.example.Model.App;
import org.example.Model.enums.LoginMenuCommands;
import org.example.Model.enums.Menu;
import org.example.Model.Result;
import org.example.Model.User;

public class LoginController {
    public static Result login(String username, String password) {
        User user = App.getUserByUsername(username);
        if(user == null) {
            return new Result(false, "username doesn't exist!");
        } else if(!user.isPasswordCorrect(password)) {
            return new Result(false, "password is incorrect!");
        }
        App.setLoggedInUser(user);
        return new Result(true, "user logged in successfully.you are now in main menu!");
    }
    public static Result forgetPassword(String username) {
        User user = App.getUserByUsername(username);
        if(user == null) {
            return new Result(false, "username doesn't exist!");
        }
        return new Result(true, "password : " + user.getPassword());
    }

}
