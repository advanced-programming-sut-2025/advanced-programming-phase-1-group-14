package org.example.Model.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuCommands implements Command{
    NEWGAME("^\\s*game\\s+new\\s+-u\\s+([A-Za-z0-9-_]+)\\s+([A-Za-z0-9-_]+)\\s+([A-Za-z0-9-_]+)\\s*$"),
    CHOOSEMAP("^\\s*game\\s+map\\s+(\\d+)\\s*$"),
    LOADGAME("load\\s+game"),
    EXITGAME("exit\\s+game"),
    DELETEGAME("delete\\s+game"),
    NEXTTURN("next\\s+turn"),
    SHOWCURRENTMENU("^\\s*show\\s+current\\s+menu\\s*$"),
    EXIT("menu\\s+exit")

    ;




    GameMenuCommands(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return this.pattern.toString();
    }
    private final Pattern pattern;
    GameMenuCommands(String regex) { pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); }
    public boolean matches(String input) { return pattern.matcher(input).matches(); }
    public Matcher getMatcher(String input) { return pattern.matcher(input); }
}
