package org.example.View;
import org.example.Model.Weather;
import org.example.Model.enums.WeatherType;
public class WeatherView {
    public void showTodayWeather(WeatherType weather) {
        System.out.println("Today's weather: " + formatWeather(weather));
    }

    public void showTomorrowForecast(WeatherType forecast) {
        System.out.println("Tomorrow's forecast: " + formatWeather(forecast));
    }

    public void showCheatApplied(WeatherType weather) {
        System.out.println("Cheat applied. Weather is now: " + formatWeather(weather));
    }

    public void showWeatherDetails(WeatherType weather) {
        System.out.println("Weather Info:");
        System.out.println("- Type: " + formatWeather(weather));
        System.out.println("- Auto Waters Crops: " + (weather.isAutoWatersCrops() ? "Yes" : "No"));
        System.out.println("- Energy Multiplier: " + weather.getEnergyMultiplier());
        System.out.println("- Has Lightning: " + (weather.hasLightning() ? "Yes" : "No"));
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    private String formatWeather(WeatherType weather) {
        String w = weather.name().toLowerCase();
        return Character.toUpperCase(w.charAt(0)) + w.substring(1); // e.g. "Sunny"
    }
}

