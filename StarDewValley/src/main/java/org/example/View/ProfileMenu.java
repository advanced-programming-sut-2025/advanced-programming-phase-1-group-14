package org.example.View;

import org.example.Controllers.ProfileMenuController;
import org.example.Model.App;
import org.example.Model.Result;
import org.example.Model.enums.Menu;
import org.example.Model.enums.ProfileMenuCommands;

import java.util.Scanner;

public class ProfileMenu implements AppMenu{
    ProfileMenuController controller = new ProfileMenuController();
    @Override
    public void check(String input) {
        //String input = scanner.nextLine().trim();
        if (ProfileMenuCommands.CHANGEUSERNAME.matches(input)) {
            handleChangeUsername(input);
        } else if (ProfileMenuCommands.CHANGENICKNAME.matches(input)) {
            handleChangeNickname(input);
        } else if (ProfileMenuCommands.CHANGEEMAIL.matches(input)) {
            handleChangeEmail(input);
        } else if (ProfileMenuCommands.CHANGEPASSWORD.matches(input)) {
            handleChangePassword(input);
        } else if (ProfileMenuCommands.USERINFO.matches(input)) {
            ProfileMenuController.showInfo();
        } else if (ProfileMenuCommands.SHOWCURRENTMENU.matches(input)) {
            System.out.println("Profile Menu");
        } else if (ProfileMenuCommands.EXIT.matches(input)) {
            App.setCurrentMenu(Menu.MainMenu);
            System.out.println("You are now in main menu.");
        } else {
            invalidCommand();
        }
    }
    public void handleChangeUsername(String input) {
        String newUsername = ProfileMenuCommands.CHANGEUSERNAME.getGroup(input, "username");
        Result result = ProfileMenuController.changeUsername(newUsername);
        System.out.println(result.message());
    }
    public void handleChangePassword(String input) {
        String newPassword = ProfileMenuCommands.CHANGEPASSWORD.getGroup(input, "password");
        String confirm = ProfileMenuCommands.CHANGEPASSWORD.getGroup(input, "passwordConfirm");
        Result result = ProfileMenuController.changePassword(newPassword, confirm);
        System.out.println(result.message());
    }
    public void handleChangeNickname(String input) {
        String newNickname = ProfileMenuCommands.CHANGENICKNAME.getGroup(input, "nickname");
        Result result = ProfileMenuController.changeNickname(newNickname);
        System.out.println(result.message());
    }
    public void handleChangeEmail(String input) {
        String newEmail = ProfileMenuCommands.CHANGEEMAIL.getGroup(input, "email");
        Result result = ProfileMenuController.changeEmail(newEmail);
        System.out.println(result.message());
    }
}
