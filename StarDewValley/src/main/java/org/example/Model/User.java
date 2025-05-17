package org.example.Model;

import org.example.Model.enums.Gender;
import org.example.Model.enums.SecurityQuestion;


public class User {
    private String username;
    private String nickname;
    private String email;
    private String password;
    private final Gender gender;
    private int gameNumbers = 0;
    private int highestMoney = 0;
    private SecurityQuestion securityQuestion;
    private String securityAnswer;

    public User(String username, String nickname, String email, String password, Gender gender,
                SecurityQuestion securityQuestion, String securityAnswer) {
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.gameNumbers = gameNumbers;
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
    public void setNickname(String nickname) { this.nickname = nickname; }

    public void setGameNumbers(int gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public void setHighestMoney(int highestMoney) {
        this.highestMoney = highestMoney;
    }

    public boolean isPasswordCorrect(String password) {
        return password.equals(this.password);
    }
    public SecurityQuestion getSecurityQuestion() { return securityQuestion; }
    public String getSecurityAnswer() { return securityAnswer; }
    public void setSecurityQuestion(SecurityQuestion q) { this.securityQuestion = q; }
    public void setSecurityAnswer(String a) { this.securityAnswer = a; }

}

