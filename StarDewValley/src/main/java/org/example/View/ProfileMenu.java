package org.example.View;

import org.example.Controllers.ProfileMenuController;
import org.example.Model.enums.ProfileMenuCommands;

import java.util.Scanner;

public class ProfileMenu implements AppMenu{
    ProfileMenuController controller = new ProfileMenuController();
    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine().trim();
        if (ProfileMenuCommands.CHANGEUSERNAME.matches(input)) {

        } else if (ProfileMenuCommands.CHANGENICKNAME.matches(input)) {

        } else if (ProfileMenuCommands.CHANGEEMAIL.matches(input)) {

        } else if (ProfileMenuCommands.CHANGEPASSWORD.matches(input)) {

        } else if (ProfileMenuCommands.USERINFO.matches(input)) {
            ProfileMenuController.showInfo();
        } else {
            invalidCommand();
        }
    }
    public void handleChangeUsername(String input) {
        String newUsername = ProfileMenuCommands.CHANGEUSERNAME.getGroup(input, "username");
        ProfileMenuController.changeUsername(newUsername);
    }
    public void handleChangePassword(String input) {
        String newPassword = ProfileMenuCommands.CHANGEPASSWORD.getGroup(input, "password");
        String confirm = ProfileMenuCommands.CHANGEPASSWORD.getGroup(input, "passwordConfirm");
        ProfileMenuController.changePassword(newPassword, confirm);
    }
    public void handleChangeNickname(String input) {
        String newNickname = ProfileMenuCommands.CHANGENICKNAME.getGroup(input, "nickname");
        ProfileMenuController.changeNickname(newNickname);
    }
    public void handleChangeEmail(String input) {
        String newEmail = ProfileMenuCommands.CHANGEEMAIL.getGroup(input, "email");
        ProfileMenuController.changeEmail(newEmail);
    }
}
