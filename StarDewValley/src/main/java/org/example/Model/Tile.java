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
}
