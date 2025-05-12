package org.example.Model.enums;

public enum Season {
    SPRING, SUMMER, AUTUMN, WINTER;

    public static Season next(Season current) {
        return values()[(current.ordinal() + 1) % values().length];
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
