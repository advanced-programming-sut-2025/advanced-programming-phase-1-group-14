package org.example.Controller;
import org.example.Model.TimeAndDate;
import org.example.View.TimeAndDateView;
public class TimeAndDateController {
    private final TimeAndDate timeanddate = TimeAndDate.getInstance();
    private final TimeAndDateView view = new TimeAndDateView();
    public void handleCommand(String command) {
        if(command.equals("time")) {
            view.showTime(timeanddate.getTime());
        } else if (command.equals("date")) {
            view.showTime(timeanddate.getDate());
        } else if (command.equals("day of the week")) {
            view.showTime(timeanddate.getWeekdays());
        } else if (command.equals("datetime")) {
            view.showTime(timeanddate.getDateTime());
        } else if (command.startsWith("cheat advance time")) {
            try {
                int h = Integer.parseInt(command.split(" ")[3].replace("h", ""));
                if (h < 0) throw new Exception();
                timeanddate.advancehour(h);
            } catch (Exception e) {
                view.showError("Invalid hour value.");
            }
        } else if (command.startsWith("cheat advance date")) {
            try {
                int d = Integer.parseInt(command.split(" ")[3].replace("d", ""));
                if (d < 0) throw new Exception();
                timeanddate.advanceday(d);
            } catch (Exception e) {
                view.showError("Invalid day value.");
            }
        }
    }
}
