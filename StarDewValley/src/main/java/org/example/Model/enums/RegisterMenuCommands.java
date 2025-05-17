package org.example.Model.enums;

import org.example.Model.enums.Command;

public enum RegisterMenuCommands implements Command {
    REGISTER("register\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)\\s+(?<passwordConfirm>\\S+)\\s+-e\\s+(?<email>\\S+)\\s+-n\\s+(?<name>\\S+)\\s+-g\\s+(?<gender>\\S+)"),
    USERNAME("[a-zA-Z0-9\\-]+"),
    PASSWORD("(?=.{8,})[a-zA-Z0-9\\?><,\"';:\\\\\\/|\\]\\[\\}\\{\\+=\\)\\(\\*&\\^%\\$#!]+"),
    EMAIL("^(?<user>[A-Za-z0-9](?:[A-Za-z0-9_-]|(?:\\.(?!\\.)))*[A-Za-z0-9])@(?<domain>(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z]{2,})$"),
    NICKNAME("[a-zA-Z0-9\\-]+"),
    GENDER("(MALE|FEMALE)"),
    GO_TO_LOGIN_MENU("go\\s+to\\s+login\\s+menu"),
    EXIT("^\\s*menu\\s+exit\\s*$"),
    SHOWCURRENTMENU("^\\s*show\\s+current\\s+menu\\s*$"),
    PICK_QUESTION(
            "^\\s*pick\\s+question\\s+-q\\s+(?<qnum>\\d+)\\s+-a\\s+(?<answer>\\S+)\\s+-c\\s+(?<answerConfirm>\\S+$)"
    ),

    ;
    private final String pattern;

    RegisterMenuCommands(String pattern) {
        this.pattern = pattern;
    }


    @Override
    public String getPattern() {
        return this.pattern;
    }
}