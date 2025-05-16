package org.example.Controllers;

import org.example.Model.App;
import org.example.Model.Result;
import org.example.Model.User;
import org.example.Model.enums.RegisterMenuCommands;

public class LoginController {
    public static Result login(String username, String password) {
        User user = App.getUserByUsername(username);
        if(user == null) {
            return new Result(false, "username doesn't exist!");
        } else if(!user.isPasswordCorrect(password)) {
            return new Result(false, "password is incorrect!");
        }
        App.setLoggedInUser(user);
        return new Result(true, "user logged in successfully.you are now in main menu!\n" +
                "1. profile menu\n2. game menu\n3. avatar menu");
    }
//    public static Result forgetPassword(String username) {
//        User user = App.getUserByUsername(username);
//        if(user == null) {
//            return new Result(false, "username doesn't exist!");
//        }
//        return new Result(true, "password : " + user.getPassword());
//    }


    public static boolean checkSecurityAnswer(User user, String answer) {
        return user.getSecurityAnswer().equals(answer);
    }

    public static Result resetPassword(User pendingUser, String newPass, String confirm) {
        if (!RegisterMenuCommands.PASSWORD.matches(newPass))
            return new Result(false, "invalid password format!");
        if (!newPass.equals(confirm))
            return new Result(false, "password confirm is wrong!");
        pendingUser.setPassword(newPass);
        return new Result(true, "password successfully reset! you are now logged in.");
    }
}
