package org.example.Model;

import org.example.Model.enums.TileType;

public class Tile {
    private TileType type;
    private boolean isWalkable;
    private String tileOwner;
    private int x;
    private int y;

    public Tile(TileType type) {
        this.type = type;
    }

    public TileType getType() {
        return type;
    }
    public boolean getIsWalkable(){
        return isWalkable;
    }
    public String getTileOwner() {
        return tileOwner;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }


    public void setWalkable(boolean isWalkable) {
        this.isWalkable = isWalkable;
    }
    public void setType(TileType type) {
        this.type = type;
    }
    public void setTileOwner(String tileOwner) {
        this.tileOwner = tileOwner;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void changeTile(){}

}