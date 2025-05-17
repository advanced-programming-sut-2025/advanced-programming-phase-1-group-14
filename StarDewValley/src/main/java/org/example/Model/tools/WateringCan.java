package org.example.Model.tools;


import org.example.Model.Tile;
import org.example.Model.enums.SkillType;
import org.example.Model.Result;

public class WateringCan extends Tool {
    private int currentWater;

    public WateringCan() {
        super(ToolType.WATERING_CAN, ToolMaterial.Initial);
        this.currentWater = getMaxWater();
    }

    private int getMaxWater() {
        switch (material) {
            case Copper -> {
                return 55;
            }
            case Iron -> {
                return 70;
            }
            case Gold -> {
                return 85;
            }
            case Iridium -> {
                return 100;
            }
            default -> {
                return 40;
            }
        }
    }

    public int getEnergyCost(int farmingLevel) {
        int cost = material.getEnergyRequired();
        if (farmingLevel >= SkillType.MAX_LEVEL) cost--;
        return Math.max(cost, 0);
    }

    public Result use(Tile tile, int farmingLevel) {
        if (tile.hasWaterSource()) {
            this.currentWater = getMaxWater();
            return new Result(true, "Watering can refilled.");
        }

        if (!tile.needsWatering()) {
            return new Result(false, "This tile doesn't need watering.");
        }

        if (currentWater <= 0) {
            return new Result(false, "The watering can is empty.");
        }

        int energy = getEnergyCost(farmingLevel);
        currentWater--;
        // tile.waterCrop(); // Apply watering to the crop

        return new Result(true, "Watered successfully. Energy used: " + energy);
    }

    public int getCurrentWater() {
        return currentWater;
    }

    public void onUpgrade() {
        this.currentWater = getMaxWater();
    }
}

