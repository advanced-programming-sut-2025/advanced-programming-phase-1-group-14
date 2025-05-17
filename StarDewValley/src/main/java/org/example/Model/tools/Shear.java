package org.example.Model.tools;

import org.example.Model.Player;
import org.example.Model.Result;
import org.example.Model.tools.Tool;
import org.example.Model.tools.ToolMaterial;
import org.example.Model.tools.ToolType;
import org.example.Model.Tile;
import org.example.Model.enums.SkillType;

public class Shear extends Tool {
    private static final int ENERGY_COST = 4;

    public Shear() {
        super(ToolType.SHEAR, ToolMaterial.Initial);
    }

    public Result use(Player player, Tile tile) {
        if (!tile.hasShearableAnimal()) {
            player.consumeEnergy(ENERGY_COST);
            return new Result(false, "There is no shearable animal here.");
        }

        player.consumeEnergy(ENERGY_COST);
        tile.shearAnimal();
        player.gainItem("wool");
        player.increaseSkill(SkillType.FARMING, 2);
        return new Result(true, "You sheared the animal successfully.");
    }
}

