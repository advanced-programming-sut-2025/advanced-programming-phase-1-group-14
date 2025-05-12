package org.example.Controller;
import org.example.Model.enums.WeatherType;
import org.example.Model.Weather;
import org.example.View.*;
public class WeatherController {
    private final Weather weather;
    private final WeatherView weatherview;

    public WeatherController(Weather weather, WeatherView weatherview) {
        this.weather = weather;
        this.weatherview  = weatherview;
    }

    public void updateWeather() {
        weather.generateTodayWeather();
        weather.generateTomorrowForecast();
    }

    public void displayTodayWeather() {
        weatherview.showTodayWeather(weather.getTodayWeather());
    }

    public void displayForecast() {
        weatherview.showTomorrowForecast(weather.getTomorrowForecast());
    }

    public void applyCheatWeather(String type) {
        try {
            WeatherType weatherType = WeatherType.valueOf(type.toUpperCase());
            weather.cheatSetWeather(weatherType);
            weatherview.showCheatApplied(weatherType);
            weatherview.showWeatherDetails(weatherType);
        } catch (IllegalArgumentException e) {
            weatherview.showError("Invalid weather type: " + type);
        }
    }
}
