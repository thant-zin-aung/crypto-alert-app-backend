package com.panda.cryptoalertapp.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class AlertType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    @ManyToMany(mappedBy = "alertTypes", cascade = CascadeType.PERSIST)
    private List<Setting> settings = new ArrayList<>();
    @ManyToOne
    private User user;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void addSetting(Setting setting) {
        settings.add(setting);
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        user.addAlertType(this);
    }
}
