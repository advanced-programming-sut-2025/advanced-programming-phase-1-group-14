package org.example.Model.enums;

public enum LoginMenuCommands implements Command {
    LOGIN("login\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)(?:\\s+--?stay-logged-in)?"),
    FORGET_PASSWORD("^\\s*forget\\s+password\\s+-u\\s+(?<username>\\S+)\\s*$"),
    ANSWER_SECURITY_QUESTION("answer\\s+-a\\s+(?<answer>\\S+)\\s*"),
    EXIT("menu\\s+exit"),
    SHOWCURRENTMENU("^\\s*show\\s+current\\s+menu\\s*$"),
    RESET_PASSWORD("reset\\s+password\\s+-p\\s+(?<password>\\S+)\\s+-c\\s+(?<confirm>\\S+)\\s*"),

    ;



    private final String pattern;

    LoginMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }
}
