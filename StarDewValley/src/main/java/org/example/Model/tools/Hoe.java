package org.example.Model.tools;

import org.example.Model.Tile;
//import org.example.Model.enums.SkillType;
import org.example.Model.enums.TileType;
import org.example.Model.Result;

public class Hoe extends Tool {
    public Hoe() {
        super(ToolType.HOE, ToolMaterial.Initial);
    }

    public int getEnergyCost(int farmingLevel) {
        int base = material.getEnergyRequired();
        //if (farmingLevel >= SkillType.MAX_LEVEL) base -= 1;
        return Math.max(base, 0);
    }

    public Result use(Tile tile, int farmingLevel) {
        int energyCost = getEnergyCost(farmingLevel);

        if (tile.getType() == TileType.FARM) {

            // tile.setTilled(true);
            return new Result(true, "Soil tilled successfully. Energy used: " + energyCost);
        } else {
            return new Result(false, "Hoe cannot be used here. Energy used: " + energyCost);
        }
    }
}