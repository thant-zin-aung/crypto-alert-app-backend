package com.panda.cryptoalertapp.services;

import com.panda.cryptoalertapp.entities.Setting;
import com.panda.cryptoalertapp.entities.User;
import com.panda.cryptoalertapp.repositories.SettingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record SettingService(SettingRepository settingRepository) {
    public void saveSetting(String tgBotToken, double targetPrice, boolean isTargetUp, boolean isTargetHit, User settingOwner) {
        settingRepository.save(new Setting(tgBotToken, targetPrice, isTargetUp, isTargetHit, settingOwner));
    }

    public List<Setting> getAllSetting() {
        return settingRepository.findAll();
    }

}
