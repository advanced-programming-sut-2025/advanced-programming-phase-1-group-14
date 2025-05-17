package org.example.Model.tools;

public enum ToolType {
    HOE("hoe"),
    PICKAXE("pick axe"),
    AXE("axe"),
    WATERING_CAN("watering can"),
    FISHING_POLE("fishing pole"),
    SCYTHE("scythe"),
    MILK_PAIL("milk pail"),
    SHEAR("shear"),
    TRASH_CAN("trash can");

    private final String name;

    ToolType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ToolType fromString(String toolString) {
        for (ToolType tool : ToolType.values()) {
            if (toolString.equalsIgnoreCase(tool.name)) {
                return tool;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}