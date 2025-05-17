package org.example.Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.example.Model.enums.Gender;
import org.example.Model.Skill;
public class User {
    private String username;
    private String nickname;
    private String email;
    private String password;
    private Gender gender;
    private int gameNumbers = 15000;
    private int highestMoney = 15000;
    private int energy = 200;
    private int maxEnergy = 200;
    private boolean isEnergyUnlimited = false;
    private boolean Fainted = false;
    private Map<Skill, Integer> skillsLevel;
    private Map<Skill, Integer> skillExperience;

    public User(String username, String nickname, String email, String password, Gender gender) {
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.skillsLevel = new HashMap<>();
        for (Skill skill : Skill.values()) {
            skillsLevel.put(skill, 0);
        }

        this.skillExperience = new HashMap<>();
        for (Skill skill : Skill.values()) {
            skillExperience.put(skill, 0);
        }
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
    public void setGender(Gender gender) {
        this.gender = gender;
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
    public int energy() {
        return energy;
    }

    public void energy(int energy) {
        this.energy = energy;
    }

    public void resetTurnEnergy() {
        this.energy = maxEnergy;
    }
    public void faint() {
    }

    public boolean hasFainted() {
        return Fainted;
    }

    public void setFainted(boolean fainted) {
        this.Fainted = fainted;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public void updateGameFields() {
        this.maxEnergy = 200;
        this.maxEnergy = 50;
        //this.playedGames += 1;
        this.energy = maxEnergy;
        this.energy = maxEnergy;
        this.skillsLevel = new HashMap<>();

        for (Skill skill : Skill.values()) {
            skillsLevel.put(skill, 0);
        }

        this.skillExperience = new HashMap<>();
        for (Skill skill : Skill.values()) {
            skillExperience.put(skill, 0);
        }

        this.Fainted = false;
    }

    public void resetEnergyForNewDay() {
        this.energy = maxEnergy;
        if (Fainted) {
            this.energy = (int) (maxEnergy * 0.75);
            this.Fainted = false;
        } else {
            this.energy = maxEnergy;
        }
    }
    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public void addSkillExperience(Skill skill) {
        int amount = skill.getXpPerAction();
        int currentLevel = skillsLevel.getOrDefault(skill, 0);
        int currentXP = skillExperience.getOrDefault(skill, 0);

        currentXP += amount;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public Map<Skill, Integer> getSkillsLevel() {
        return skillsLevel;
    }

    public void setSkillsLevel(Map<Skill, Integer> skillsLevel) {
        this.skillsLevel = skillsLevel;
    }

    public Map<Skill, Integer> getSkillExperience() {
        return skillExperience;
    }

    public void setSkillExperience(Map<Skill, Integer> skillExperience) {
        this.skillExperience = skillExperience;
    }

    public void reduceEnergy(int amount) {
        this.energy -= amount;
        handleFainting();
    }

    public void handleFainting() {
        if (this.energy <= 0) {
            this.energy = 0;
            this.Fainted = true;
        }
    }
    public void addEnergy(int amount) {
        if (amount < 0) return;
        this.energy = Math.min(this.energy + amount, maxEnergy);
    }
}