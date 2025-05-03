package org.example.Model;

public class User {;
    private String username;
    private String email;
    private String password;
    private boolean gender;
    private int GameNumbers = 1;
    private User(String username, String email, String password, boolean gender) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.GameNumbers = GameNumbers;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public boolean isGender() {
        return gender;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }

}

