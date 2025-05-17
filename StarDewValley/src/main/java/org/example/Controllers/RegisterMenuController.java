package org.example.Controllers;

import org.example.Model.App;
import org.example.Model.Result;
import org.example.Model.User;
import org.example.Model.enums.Gender;
import org.example.Model.enums.RegisterMenuCommands;
import org.example.Model.enums.SecurityQuestion;

import java.util.Arrays;
import java.util.List;

public class RegisterMenuController {
    private static List<SecurityQuestion> pendingQuestions;

    public static Result register(String username, String password, String email, String nickname, Gender gender) {
        if(!RegisterMenuCommands.USERNAME.matches(username)) {
            return new Result(false, "username format is invalid!");
        }
        //inja kar ba file bayad anjam beshe:
        else if(App.getUserByUsername(username) != null) {
             return new Result(false, "this username is already taken!");
        }
        else if(!RegisterMenuCommands.PASSWORD.matches(password)) {
            return new Result(false, "password format is invalid!");
        }
        else if(!validateEmail(email)) {
            return new Result(false, "email format is invalid!");

        }
        pendingQuestions = Arrays.asList(SecurityQuestion.values());
        return new Result(true, "please choose a security question. \n" + listQuestions());
        //App.addUser(new User(username, nickname, email, password, gender, securityQuestion, securityAnswer));
        //return new Result(true, "user registered successfully.you are now in login menu!");
    }
    private static boolean validateEmail(String email) {
        if(!RegisterMenuCommands.EMAIL.matches(email)) {
            return false;
        }
        return true;
    }
    private static String listQuestions() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pendingQuestions.size(); i++) {
            sb.append(String.format("%d) %s%n", i+1, pendingQuestions.get(i).getText()));
        }
        return sb.toString();
    }
    public static Result pickSecurityQuestion(String username, String password, String email, String nickname,
                                              Gender gender, int qnum, String ans, String ansConfirm) {
        if (ans == null || !ans.equals(ansConfirm)) {
            return new Result(false, "invalid answer! Try again.");
        }
        SecurityQuestion q = SecurityQuestion.fromIndex(qnum);
//        user.setSecurityQuestion(q);
//        user.setSecurityAnswer(ans);

        App.addUser(new User(username, nickname, email, password, gender, q, ans));
        return new Result(true, "user registered successfully.you are now in login menu!");
    }
}
