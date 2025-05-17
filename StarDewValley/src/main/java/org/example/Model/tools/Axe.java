package org.example.Model.tools;

import org.example.Model.Result;
import org.example.Model.Tile;

public class Axe extends Tool{
public Axe() {
    super(ToolType.AXE, ToolMaterial.Initial);
}

public int getEnergyCost(boolean success, int foragingLevel) {
    int cost = material.getEnergyRequired() - (success ? 0 : 1);
    if (foragingLevel >= SkillType.MAX_LEVEL) cost--;
    return Math.max(cost, 0);
}

public Result use(Tile tile, int foragingLevel) {
    boolean canChop = canChop(tile);
    int energy = getEnergyCost(canChop, foragingLevel);

    if (canChop) {
        // tile.clearTreeOrBranch();
        return new Result(true, "Chopped successfully. Energy used: " + energy);
    } else {
        return new Result(false, "Axe cannot be used here. Energy used: " + energy);
    }
}

private boolean canChop(Tile tile) {
    return tile.getType() == TileType.TREE || tile.getType() == TileType.BRANCH;
}
}