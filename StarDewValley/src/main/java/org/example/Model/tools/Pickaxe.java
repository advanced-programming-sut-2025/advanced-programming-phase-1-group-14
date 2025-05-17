package org.example.Model.tools;

import org.example.Model.Tile;
//import org.example.Model.enums.SkillType;
import org.example.Model.enums.TileType;
import org.example.Model.Result;

public class Pickaxe extends Tool {
    public Pickaxe() {
        super(ToolType.PICKAXE, ToolMaterial.Initial);
    }

    public int getEnergyCost(boolean success, int miningLevel) {
        int cost = material.getEnergyRequired() - (success ? 0 : 1);
        //if (miningLevel >= SkillType.MAX_LEVEL) cost--;
        return Math.max(cost, 0);
    }

    public Result use(Tile tile, int miningLevel, int oreLevel) {
        boolean canBreak = canBreak(tile, oreLevel);
        int energy = getEnergyCost(canBreak, miningLevel);

        if (canBreak) {
            // tile.clearObject();
            return new Result(true, "Object destroyed. Energy used: " + energy);
        } else {
            return new Result(false, "Pickaxe is not strong enough. Energy used: " + energy);
        }
    }

    private boolean canBreak(Tile tile, int oreLevel) {
        if (tile.getType().name().contains("ORE")) {
            return canBreakOreLevel(oreLevel);
        }

        return tile.getType() == TileType.FARM;
    }

    private boolean canBreakOreLevel(int oreLevel) {
        return switch (material) {
            case Initial -> oreLevel <= 0;
            case Copper -> oreLevel <= 1;
            case Iron -> oreLevel <= 2;
            case Gold -> oreLevel <= 3;
            case Iridium -> true;
        };
    }
}

