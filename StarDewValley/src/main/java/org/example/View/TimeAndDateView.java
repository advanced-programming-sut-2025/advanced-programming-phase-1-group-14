package org.example.View;

public class TimeAndDateView {
    public void showTime(String time) {
        System.out.println("Time: " + time);
    }

    public void showDate(String date) {
        System.out.println("Date: " + date);
    }

    public void showDateTime(String datetime) {
        System.out.println("Date & Time: " + datetime);
    }

    public void showDayOfWeek(String day) {
        System.out.println("Day of Week: " + day);
    }

    public void showError(String errorMessage) {
        System.out.println("Error! -> " + errorMessage);
    }

}
