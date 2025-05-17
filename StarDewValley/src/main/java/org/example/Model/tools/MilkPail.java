//package org.example.Model.tools;
//
//import org.example.Model.Result;
//import org.example.Model.Tile;
//
//public class MilkPail extends Tool{
//    private static final int ENERGY_COST = 4;
//
//    public MilkPail() {
//        super(ToolType.MILK_PAIL, ToolMaterial.Initial);
//    }
//
//    public Result use(Player player, Tile tile) {
//        if (!tile.hasMilkableAnimal()) {
//            player.consumeEnergy(ENERGY_COST);
//            return new Result(false, "There is no animal to milk here.");
//        }
//
//        player.consumeEnergy(ENERGY_COST);
//        tile.milkAnimal();
//        player.gainItem("milk");
//        player.increaseSkill(SkillType.FARMING, 2);
//        return new Result(true, "You milked the animal successfully.");
//    }
//}