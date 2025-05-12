package org.example.Model.enums;

public enum WeatherType {
    SUNNY(false, 1.0, false),
    RAIN(true, 1.5, false),
    STORM(true, 0.5, true),
    SNOW(false, 2.0, false);

    private final boolean autoWatersCrops;
    private final double energyMultiplier;
    private final boolean hasLightning;

    WeatherType(boolean autoWatersCrops, double energyMultiplier, boolean hasLightning) {
        this.autoWatersCrops = autoWatersCrops;
        this.energyMultiplier = energyMultiplier;
        this.hasLightning = hasLightning;
    }

    public boolean isAutoWatersCrops() {
        return autoWatersCrops;
    }

    public double getEnergyMultiplier() {
        return energyMultiplier;
    }

    public boolean hasLightning() {
        return hasLightning;
    }
}

