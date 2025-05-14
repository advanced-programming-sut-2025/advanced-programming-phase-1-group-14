package org.example.Model;

public class Game {
    private final Weather weather = new Weather();
    private final TimeAndDate timeAndDate = TimeAndDate.getInstance();

    public Weather getWeather() {
        return weather;
    }

    public TimeAndDate getTimeAndDate() {
        return timeAndDate;
    }
    //این ادامه پیدا میگنه برای بقیه چیزا
    private final GameMap gameMap;

    public Game() {
        this.gameMap = new GameMap();
    }
    public GameMap getGameMap() {
        return gameMap;
    }




    
}
