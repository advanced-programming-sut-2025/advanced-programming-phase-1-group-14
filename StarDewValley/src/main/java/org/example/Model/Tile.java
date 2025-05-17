package org.example.Model;

import org.example.Model.enums.TileType;

public class Tile {
    private TileType type;

    public Tile(TileType type) {
        this.type = type;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public char getSymbol() {
        return switch (type) {
            case EMPTY -> '.';
            case FARM -> 'F';
            case VILLAGE -> 'V';
            case GREENHOUSE -> 'G';
            case CABIN -> 'C';
            case LAKE -> 'L';
            case QUARRY -> 'Q';
        };
    }


    private boolean hoed = false;             // آیا شخم زده شده؟
    private boolean planted = false;          // آیا محصولی کاشته شده؟
    private boolean watered = false;          // آیا آب داده شده؟
    private boolean hasGrass = false;         // آیا روی کاشی علف هست؟
    private boolean readyToHarvest = false;   // آیا محصول آماده برداشت است؟



    public boolean isHoed() {
        return hoed;
    }

    public void hoe() {
        this.hoed = true;
    }

    public boolean isPlanted() {
        return planted;
    }

    public void plantCrop() {
        this.planted = true;
    }

    public boolean isWatered() {
        return watered;
    }

    public void water() {
        this.watered = true;
    }

    public void resetWatering() {
        this.watered = false;
    }

    public boolean hasWaterSource() {
        return type == TileType.LAKE;
    }

    public boolean hasGrass() {
        return hasGrass;
    }

    public void setGrass(boolean hasGrass) {
        this.hasGrass = hasGrass;
    }

    public boolean isReadyToHarvest() {
        return readyToHarvest;
    }

    public void setReadyToHarvest(boolean readyToHarvest) {
        this.readyToHarvest = readyToHarvest;
    }

    public void harvest() {
        if (readyToHarvest) {
            readyToHarvest = false;
            planted = false;
        }
    }

    public void clear() {
        this.hoed = false;
        this.planted = false;
        this.watered = false;
        this.hasGrass = false;
        this.readyToHarvest = false;
    }


}
