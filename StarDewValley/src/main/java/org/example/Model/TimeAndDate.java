package org.example.Model;
import org.example.Model.enums.Season;
public class TimeAndDate {
    private static TimeAndDate instance;
    private int hour = 9, day = 1,seasonIndex = 0, year = 1;
    private Season currentSeason = Season.SPRING;
    private static final String[] weekdays = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private TimeAndDate() {}
    public static TimeAndDate getInstance() {
        if (instance == null) {
            instance = new TimeAndDate();
        }
        return instance;
    }
    public void advancehour(int h) {
        if(h < 0)
            return;
        hour += h;
        while(hour >= 24){
            hour -= 24;
            advanceday(1);
        }

    }
    public void advanceday(int d) {
        if (d < 0)
            return;
        day += d;
        while (d > 28) {
            day -= 28;
            seasonIndex++;
            if(seasonIndex > 3){
                seasonIndex = 0;
                year++;
            }
        }
    }
    public String getTime(){
        return String.format("%02d:00", hour);
    }
    public String getDate(){
        return String.format("%s %d, Year %d", currentSeason, day, year);
    }

    public String getWeekdays() {
        int totalDays = (currentSeason.ordinal() * 28) + (day - 1);
        return weekdays[totalDays % 7];
    }
    public String getDateTime() {
        return getDate() + " - " + getTime();
    }
    public Season getSeason() {
        return currentSeason;
    }
}

