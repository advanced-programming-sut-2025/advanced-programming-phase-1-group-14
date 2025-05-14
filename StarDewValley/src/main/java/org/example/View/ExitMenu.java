package org.example.View;

import java.util.Scanner;

public class ExitMenu implements AppMenu{
    @Override
    public void check(String input) {
        throw new RuntimeException("Goodbye!");
    }

    //System.exit(0);

}

