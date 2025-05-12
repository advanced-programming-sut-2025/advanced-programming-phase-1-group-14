package org.example.Model;
import org.example.Model.enums.Season;
import org.example.Model.TimeAndDate;
import org.example.Model.enums.WeatherType;

import java.util.Random;
public class Weather {
    private final TimeAndDate timeAndDate = TimeAndDate.getInstance();

    private WeatherType todayWeather;
    private WeatherType tomorrowForecast;

    public void generateTodayWeather() {
        this.todayWeather = randomWeatherForSeason(timeAndDate.getSeason());
    }

    public void generateTomorrowForecast() {
        this.tomorrowForecast = randomWeatherForSeason(timeAndDate.getSeason());
    }

    private WeatherType randomWeatherForSeason(Season season) {
        Random rand = new Random();
        return switch (season) {
            case SPRING, SUMMER, AUTUMN ->
                    new WeatherType[]{WeatherType.SUNNY, WeatherType.RAIN, WeatherType.STORM}[rand.nextInt(3)];
            case WINTER -> WeatherType.SNOW;
            default -> WeatherType.SUNNY;
        };
    }


    public WeatherType getTodayWeather() {
        return todayWeather;
    }

    public WeatherType getTomorrowForecast() {
        return tomorrowForecast;
    }

    public void cheatSetWeather(WeatherType newWeather) {
        this.todayWeather = newWeather;
    }
}
