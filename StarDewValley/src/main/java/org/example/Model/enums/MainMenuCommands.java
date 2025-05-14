package org.example.Model.enums;

public enum MainMenuCommands implements Command{
    ENTER_PROFILE_MENU("^\\s*menu\\s+enter\\s+profile\\s*$"),
    ENTER_GAME_MENU("menu\\s+enter\\s+game"),
    ENTER_AVATAR_MENU("menu\\s+enter\\s+avatar"),
    LOGOUT("user\\s+logout"), //mesle exit baraye baghie menu ha
    SHOWCURRENTMENU("^\\s*show\\s+current\\s+menu\\s*$")

    ;

    private final String pattern;


    MainMenuCommands(String pattern) {
        this.pattern = pattern;
    }
    @Override
    public String getPattern() {
        return "";
    }
}
