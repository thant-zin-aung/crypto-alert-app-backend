package com.panda.cryptoalertapp.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class AlertType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    @ManyToMany(mappedBy = "alertTypes")
    private List<Setting> settings = new ArrayList<>();

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
}
