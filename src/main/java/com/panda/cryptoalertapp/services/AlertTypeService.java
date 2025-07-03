package com.panda.cryptoalertapp.services;

import com.panda.cryptoalertapp.entities.AlertType;
import com.panda.cryptoalertapp.entities.Telegram;
import com.panda.cryptoalertapp.entities.User;
import com.panda.cryptoalertapp.repositories.TelegramRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertTypeService {
    private final TelegramRepository telegramRepository;
    public AlertTypeService(TelegramRepository telegramRepository) {
        this.telegramRepository =  telegramRepository;
    }

    public void saveNewConfig(AlertType alertType) {
        if(alertType instanceof Telegram telegram) {
            telegramRepository.save(telegram);
        }
    }
}
