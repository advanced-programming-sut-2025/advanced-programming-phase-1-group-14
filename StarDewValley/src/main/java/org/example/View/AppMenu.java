package org.example.View;

import java.util.Scanner;


public interface AppMenu {
    public void check(String input);
    public default void invalidCommand() {
        System.out.println("invalid command!");
    }
}
