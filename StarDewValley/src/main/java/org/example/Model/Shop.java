package org.example.Model;

import java.util.ArrayList;

public class Shop extends Place {
    private String shopName;
    private String shopOwner;
    private int startHour;
    private int endHour;

    public Shop(String shopName, String shopOwner, int startHour, int endHour, int startX, int startY, int width, int height) {
        this.shopName = shopName;
        this.shopOwner = shopOwner;
        this.startHour = startHour;
        this.endHour = endHour;
        this.x = startX;
        this.y = startY;
        this.width = width;
        this.height = height;

    }
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopOwner() {
        return shopOwner;
    }

    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

}
