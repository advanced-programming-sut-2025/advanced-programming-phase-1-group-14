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

    public User(String username, String nickname, String email, String password, Gender gender) {
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public User(String name, String username, String email, String password, Gender gender) {
        this.username = username;
        this.nickname = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public String getUserName() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getNickname() {
        return nickname;
    }
    public Gender getGender() {
        return gender;
    }

    public int getGameNumbers() {
        return gameNumbers;
    }
    public int getHighestMoney() {
        return highestMoney;
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
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setGameNumbers(int gameNumbers) {
        this.gameNumbers = gameNumbers;
    }
    public void setHighestMoney(int highestMoney) {
        this.highestMoney = highestMoney;
    }
}

