package org.example.Model;

import org.example.Model.enums.TileType;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    public static final int WIDTH = 150;
    public static final int HEIGHT = 150;
    private final Tile[][] tiles = new Tile[HEIGHT][WIDTH];
    private final List<User> farmOwners;
    public GameMap(ArrayList<User> firstNUsers) {
        this.farmOwners = farmOwners;
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



    // برای دسترسی بعدی به Tileها
    public Tile getTile(int x, int y) {
        return tiles[y][x];
    }

    private void createFarmForMap(User owner, int startX, int startY) {
        int width = 39;
        int height = 39;

        Farm farm = new Farm(owner, startX, startY);
        farm.setWidth(width);
        farm.setHeight(height);

        farm.setGreenHouse(new GreenHouse(startX + 1, startY + 1, 6, 5));
        farm.setHouse(new House(startX + 1, startY + 30, 4, 4));
        farm.setQuarry(new Quarry(startX + 30, startY + 10, 6, 4));

        farm.setTileTypes(tiles);
    }
    private void placeFarms() {
        if (farmOwners.size() > 0)
            createFarmForMap(farmOwners.get(0), 0, 0); // بالا چپ
        if (farmOwners.size() > 1)
            createFarmForMap(farmOwners.get(1), 110, 0); // بالا راست
        if (farmOwners.size() > 2)
            createFarmForMap(farmOwners.get(2), 0, 110); // پایین چپ
        if (farmOwners.size() > 3)
            createFarmForMap(farmOwners.get(3), 110, 110); // پایین راست        // پایین راست
    }
    public void printMap() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(tiles[y][x].getType().coloredSymbol());
            }
            System.out.println();
        }
    }

//    private void placeRandomObjectsInFarm(int xStart, int yStart, int xEnd, int yEnd) {
//        TileType[] decorations = {TileType.CABIN, TileType.LAKE, TileType.GREENHOUSE, TileType.QUARRY};
//        for (TileType type : decorations) {
//            // قرار دادن یکی از هر نوع به صورت تصادفی
//            int x = (int) (Math.random() * (xEnd - xStart)) + xStart;
//            int y = (int) (Math.random() * (yEnd - yStart)) + yStart;
//            tiles[y][x].setType(type);
//        }
//    }


}
