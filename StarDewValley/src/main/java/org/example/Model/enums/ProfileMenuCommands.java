package org.example.Model.enums;

public enum ProfileMenuCommands implements Command{
    CHANGEUSERNAME("change\\s+username\\s+-u\\s+(?<username>\\S+)\\s*"),
    CHANGEPASSWORD("change\\s+password\\s+-p\\s+(?<password>\\S+)\\s+-o\\s+(?<passwordConfirm>\\S+)"),
    CHANGEEMAIL("change\\s+email\\s+-e\\s+(?<email>\\S+)\\s*"),
    CHANGENICKNAME("change\\s+nickname\\s+-u\\s+(?<nickname>\\S+)\\s*"),
    USERINFO("user\\s+info\\s*")

    ;
    private final String pattern;
    ProfileMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return "";
    }
}
