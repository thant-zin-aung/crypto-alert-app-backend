package com.panda.cryptoalertapp.entities;

import jakarta.persistence.*;

@Entity
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    private String tgBotToken;
    private long tgChatId;
    private double targetPrice;
    private boolean isTargetUp;
    private boolean isTargetHit;
    @ManyToOne
    private User user;

    public Setting() {
    }

    public Setting(String tgBotToken, long tgChatId, double targetPrice, boolean isTargetUp, boolean isTargetHit, User user) {
        this.tgBotToken = tgBotToken;
        this.tgChatId = tgChatId;
        this.targetPrice = targetPrice;
        this.isTargetUp = isTargetUp;
        this.isTargetHit = isTargetHit;
        this.user = user;
    }

    public String getTgBotToken() {
        return tgBotToken;
    }

    public void setTgBotToken(String tgBotToken) {
        this.tgBotToken = tgBotToken;
    }

    public long getTgChatId() {
        return tgChatId;
    }

    public void setTgChatId(long tgChatId) {
        this.tgChatId = tgChatId;
    }

    public double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(double targetPrice) {
        this.targetPrice = targetPrice;
    }

    public boolean isTargetUp() {
        return isTargetUp;
    }

    public void setTargetUp(boolean targetUp) {
        isTargetUp = targetUp;
    }

    public boolean isTargetHit() {
        return isTargetHit;
    }

    public void setTargetHit(boolean targetHit) {
        isTargetHit = targetHit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
