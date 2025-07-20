package com.panda.cryptoalertapp.services;

import com.panda.cryptoalertapp.entities.AlertType;
import com.panda.cryptoalertapp.entities.Setting;
import com.panda.cryptoalertapp.entities.Telegram;
import com.panda.cryptoalertapp.entities.User;
import com.panda.cryptoalertapp.repositories.SettingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettingService {
    private final SettingRepository settingRepository;
    private final TelegramService telegramService;
    public SettingService(SettingRepository settingRepository, TelegramService telegramService) {
        this.settingRepository = settingRepository;
        this.telegramService = telegramService;
    }
    public void saveSetting(AlertType.AlertTypes alertType, double targetPrice, boolean isTargetUp, User settingOwner) throws Exception {
        if(alertType == AlertType.AlertTypes.TELEGRAM ) {
            Setting setting = new Setting(targetPrice, isTargetUp, false, settingOwner);
            setting.addAlertType(settingOwner.getAlertTypes().stream().filter(alert -> alert instanceof Telegram).findFirst().get());
            settingRepository.save(setting);

        }
    }
    public void updateSetting(Setting setting) {
        settingRepository.save(setting);
    }

    public List<Setting> getAllSetting() {
        return settingRepository.findAll();
    }

}
