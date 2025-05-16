package org.example.Model;

import org.example.Model.enums.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


            private static final Map<Menu, List<Menu>> transitions = new HashMap<>();

            static {
                transitions.put(Menu.RegisterMenu, List.of(Menu.LoginMenu));
                transitions.put(Menu.LoginMenu, List.of(Menu.MainMenu));

                transitions.put(Menu.MainMenu, List.of(Menu.ProfileMenu, Menu.GameMenu));

                transitions.put(Menu.ProfileMenu, List.of(Menu.MainMenu));
                transitions.put(Menu.GameMenu, List.of(Menu.MainMenu));
            }

            public static boolean canEnter(Menu from, Menu to) {
                return transitions.getOrDefault(from, List.of()).contains(to);
            }
    private static final TimeAndDate timeAndDate = TimeAndDate.getInstance();

    public static TimeAndDate getTimeAndDate() {
        return timeAndDate;
    }
    private static Game currentGame;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void startNewGame() {
        currentGame = new Game();
    }
    public static void printGameMap() {
        if (currentGame != null) {
            currentGame.getGameMap().printMap();
        } else {
            System.out.println("Game has not started yet.");
        }
    }


}

