package org.example.Model;

import org.example.Model.enums.Gender;

public class User {
    private String username;
    private String nickname;
    private String email;
    private String password;
    private Gender gender;
    private int gameNumbers = 0;
    private int highestMoney = 0;

    private User(String username, String nickname, String email, String password, Gender gender) {
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.gameNumbers = gameNumbers;
        int chetori;
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
    public String getNickname() { return nickname; }
    public Gender GetGender() {
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
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setNickname(String nickname) { this.nickname = nickname; }


}

