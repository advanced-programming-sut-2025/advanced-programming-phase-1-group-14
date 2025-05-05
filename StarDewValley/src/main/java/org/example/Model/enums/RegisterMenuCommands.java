package org.example.Model.enums;

import org.example.Model.enums.Command;

public enum RegisterMenuCommands implements Command {
    REGISTER("register\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)\\s+(?<passwordConfirm>\\S+)\\s+-e\\s+(?<email>\\S+)\\s+-n\\s+(?<name>\\S+)\\s+-g\\s+(?<gender>\\S+)"),
    USERNAME("[a-zA-Z0-9\\-]+"),
    PASSWORD("[a-zA-Z0-9\\?><,\"';:\\\\\\/|\\]\\[\\}\\{\\+=\\)\\(\\*&\\^%\\$#!]+"),
    EMAIL("(?=^[^@]*@[^@]*$)(?<email>([a-zA-Z0-9](?:[a-zA-Z0-9._-]*[a-zA-Z0-9])?)@([a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?(?:\\.[a-zA-Z]{2,})+))"),
    NICKNAME("[a-zA-Z0-9\\-]+"),
    GENDER("(MALE|FEMALE)"),
    GO_TO_LOGIN_MENU("go\\s+to\\s+login\\s+menu"),
    EXIT("Menu exit");
    private final String pattern;

    RegisterMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }
}