package org.example.Model;

import org.example.Model.enums.Menu;

import java.util.ArrayList;

public class App {
    private static final ArrayList<User> users = new ArrayList<>();
    private static User loggedInUser;
    private static Menu currentMenu = Menu.RegisterMenu;
    public static void setCurrentMenu(Menu currentMenu) {
        App.currentMenu = currentMenu;
    }
    public static ArrayList<User> getUsers() {
        return users;
    }
    public static User getLoggedInUser() {
        return loggedInUser;
    }
    public static void setLoggedInUser(User loggedInUser) {
        App.loggedInUser = loggedInUser;
    }
    public static void addUser(User user){
        users.add(user);
    }
    public static Menu getCurrentMenu() {
        return currentMenu;
    }
    public static User getUserByUsername(String username) {
        for(User user : users) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    private static final TimeAndDate timeAndDate = TimeAndDate.getInstance();

    public static TimeAndDate getTimeAndDate() {
        return timeAndDate;
    }
}