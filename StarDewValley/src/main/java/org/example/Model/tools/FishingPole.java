package org.example.Model.tools;

import org.example.Model.Tile;
//import org.example.Model.enums.SkillType;
import org.example.Model.Result;
import org.example.Model.enums.Skill;


public class FishingPole extends Tool {
    public FishingPole() {
        super(ToolType.FISHING_POLE, ToolMaterial.Initial);
    }


    public Result use(Player player, Tile tile) {
        if (!tile.hasWaterSource()) {
            return new Result(false, "You can't fish here. There is no water source.");
        }

        int energyCost = getEnergyCost(player);
        if (player.getEnergy() < energyCost) {
            return new Result(false, "Not enough energy to fish.");
        }

        player.decreaseEnergy(energyCost);

        switch (material) {
            case Initial:
                return tryCatchFish(player, FishQuality.COMMON);
            case Copper:
                return tryCatchFish(player, FishQuality.ANY);
            case Iron:
                return tryCatchFish(player, FishQuality.ANY);
            case Gold:
                return tryCatchFish(player, FishQuality.ANY);
            case Iridium:
                return tryCatchFish(player, FishQuality.ANY);
            default:
                return new Result(false, "Invalid fishing pole material.");
        }
    }

    private int getEnergyCost(Player player) {
        int baseEnergy;
        switch (material) {
            case Initial:
            case Copper:
                baseEnergy = 8;
                break;
            case Iron:
                baseEnergy = 6;
                break;
            case Iridium:
                baseEnergy = 4;
                break;
            default:
                baseEnergy = 8;
        }

        if (player.getSkill(Skill.FISHING) == Skill.MAX_LEVEL)
            baseEnergy -= 1;

        return Math.max(0, baseEnergy);
    }

    private Result tryCatchFish(Player player, FishQuality maxQuality) {
        // simulate catching fish
        Fish fish = Fish.randomFish(maxQuality, player.getCurrentSeason());
        player.getInventory().add(fish);
        return new Result(true, "You caught a " + fish.getName() + "!");
    }
}

