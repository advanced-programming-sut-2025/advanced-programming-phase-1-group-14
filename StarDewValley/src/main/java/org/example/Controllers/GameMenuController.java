package org.example.Controllers;

import org.example.Model.enums.GameMenuCommands;

public class GameMenuController {
    private void handleChooseMap(String input) {
        var m = GameMenuCommands.CHOOSEMAP.getMatcher(input);
        m.matches();
        int mapNum = Integer.parseInt(m.group(1));
        String player = model.getCurrentPlayer();

        // TODO: Validate map number within allowed range
        if (!gameService.isValidMap(mapNum)) {
            view.show("Error: Map number " + mapNum + " is invalid.");
            return;
        }

        model.setMapChoice(player, mapNum);
        view.show(player + " selected map #" + mapNum);
        model.advanceTurn();
    }
    private void handleNewGame() {



    }
}
