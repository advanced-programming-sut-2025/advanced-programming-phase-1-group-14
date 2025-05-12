package org.example.View;

import org.example.Controllers.GameMenuController;
import org.example.Model.App;
import org.example.Model.enums.GameMenuCommands;
import org.example.Model.enums.Menu;
import org.example.Model.enums.RegisterMenuCommands;

import java.util.Scanner;

public class GameMenu implements AppMenu{
    @Override
    public void check(Scanner scanner) {
        GameMenuController controller = new GameMenuController();
        String input = scanner.nextLine().trim();
        if (GameMenuCommands.CHOOSEMAP.matches(input)) {

        } else if (GameMenuCommands.NEWGAME.matches(input)) {

        } else if (GameMenuCommands.DELETEGAME.matches(input)) {

        } else if (GameMenuCommands.LOADGAME.matches(input)) {

        } else if (GameMenuCommands.NEXTTURN.matches(input)) {

        } else if (GameMenuCommands.EXITGAME.matches(input)) {

        }
        else {
            invalidCommand();
        }
    }
}
