package org.example.Model;

public class Game {
    private final Weather weather = new Weather();
    private final TimeAndDate timeAndDate = TimeAndDate.getInstance();
    private final GameMap gameMap;

    public Game() {
        this.gameMap = new GameMap(App.getFirstNUsers(4));
    }
    public Weather getWeather() {
        return weather;
    }

    public TimeAndDate getTimeAndDate() {
        return timeAndDate;
    }
    public GameMap getGameMap() {
        return gameMap;
    }
}
