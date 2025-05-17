package org.example.Model.enums;

public enum SecurityQuestion {
    FIRST_NAME("What is your first name?"),
    FIRST_PET("What was the name of your first pet?"),
    BIRTH_CITY("In what city were you born?"),
    FAVORITE_COLOR("What is your favorite color?");

    private final String text;

    SecurityQuestion(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static void printAll() {
        for (int i = 0; i < values().length; i++) {
            System.out.printf("%d) %s%n", i+1, values()[i].getText());
        }
    }

    public static SecurityQuestion fromIndex(int idx) {
        if (idx < 1 || idx > values().length)
            throw new IllegalArgumentException("Invalid question number");
        return values()[idx-1];
    }
}