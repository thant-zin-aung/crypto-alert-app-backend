package com.panda.cryptoalertapp.services;

import com.panda.cryptoalertapp.entities.Setting;
import com.panda.cryptoalertapp.entities.User;
import com.panda.cryptoalertapp.repositories.SettingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettingService {
    private final SettingRepository settingRepository;
    private final TelegramService telegramService;
    public SettingService(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
        this.telegramService = new TelegramService();
    }
    public void saveSetting(String tgBotToken, double targetPrice, boolean isTargetUp, User settingOwner) throws Exception {
        Optional<Long> tgChatId = telegramService.getLatestChatId(tgBotToken);
        if(tgChatId.isPresent()) {
            settingRepository.save(new Setting(targetPrice, isTargetUp, false, settingOwner));
        } else {
            throw new Exception("Telegram chat id cannot be retrieved. Make sure to send at least one message to telegram bot.");
        }
    }
    public void updateSetting(Setting setting) {
        settingRepository.save(setting);
    }

    public List<Setting> getAllSetting() {
        return settingRepository.findAll();
    }

}
