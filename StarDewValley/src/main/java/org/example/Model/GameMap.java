package org.example.Model;

import org.example.Model.enums.TileType;

public class GameMap {
    public static final int WIDTH = 150;
    public static final int HEIGHT = 150;
    private final Tile[][] tiles = new Tile[HEIGHT][WIDTH];

    public GameMap() {
        initializeEmptyMap();
        placeFarms();
        placeVillage();
    }

    private void initializeEmptyMap() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                tiles[y][x] = new Tile(TileType.EMPTY);
            }
        }
    }

    private void placeFarms() {
        // Farm 1 (top-left)
        fillArea(0, 0, 39, 39, TileType.FARM);
        placeRandomObjectsInFarm(0, 0, 39, 39);
        // Farm 2 (top-right)
        fillArea(80, 0, 119, 39, TileType.FARM);
        placeRandomObjectsInFarm(80, 0, 120, 40);
        // Farm 3 (bottom-left)
        fillArea(0, 80, 39, 119, TileType.FARM);
        placeRandomObjectsInFarm(0, 80, 39, 119);
        // Farm 4 (bottom-right)
        fillArea(80, 80, 119, 119, TileType.FARM);
        placeRandomObjectsInFarm(80, 80, 119, 119);

    }

    private void placeVillage() {
        // Central 100x100 square for village
        fillArea(40, 40, 79, 79, TileType.VILLAGE);
    }

    private void fillArea(int xStart, int yStart, int xEnd, int yEnd, TileType type) {
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                tiles[y][x].setType(type);
            }
        }
    }

    public void printMap() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(tiles[y][x].getSymbol());
            }
            System.out.println();
        }
    }

    // برای دسترسی بعدی به Tileها
    public Tile getTile(int x, int y) {
        return tiles[y][x];
    }

    private void placeRandomObjectsInFarm(int xStart, int yStart, int xEnd, int yEnd) {
        TileType[] decorations = {TileType.CABIN, TileType.LAKE, TileType.GREENHOUSE, TileType.QUARRY};
        for (TileType type : decorations) {
            // قرار دادن یکی از هر نوع به صورت تصادفی
            int x = (int) (Math.random() * (xEnd - xStart)) + xStart;
            int y = (int) (Math.random() * (yEnd - yStart)) + yStart;
            tiles[y][x].setType(type);
        }
    }


}
