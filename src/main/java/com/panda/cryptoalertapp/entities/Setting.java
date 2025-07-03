package com.panda.cryptoalertapp.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    private double targetPrice;
    private boolean isTargetUp;
    private boolean isTargetHit;
    @ManyToOne
    private User user;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<AlertType> alertTypes = new ArrayList<>();

    public Setting() {
    }

    public Setting(double targetPrice, boolean isTargetUp, boolean isTargetHit, User user) {
        this.targetPrice = targetPrice;
        this.isTargetUp = isTargetUp;
        this.isTargetHit = isTargetHit;
        this.user = user;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSid() {
        return sid;
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

    public void addAlertType(AlertType alertType) {
        alertTypes.add(alertType);
        alertType.addSetting(this);
    }

    public List<AlertType> getAlertTypes() {
        return alertTypes;
    }
}
