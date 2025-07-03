package com.panda.cryptoalertapp.controllers;

import com.panda.cryptoalertapp.entities.Telegram;
import com.panda.cryptoalertapp.entities.User;
import com.panda.cryptoalertapp.services.TelegramService;
import com.panda.cryptoalertapp.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertConfigController {
    private UserService userService;
    private TelegramService telegramService;

    public AlertConfigController(UserService userService, TelegramService telegramService) {
        this.userService = userService;
        this.telegramService = telegramService;
    }

    @PostMapping("/saveTelegramAlert")
    public void saveNewAlertType(@RequestParam("uid") int uid, @RequestParam("botToken") String botToken, @RequestParam("chatId") long chatId) {
        User user = userService.findUserById(uid);
        Telegram telegram = new Telegram(botToken, chatId);
        telegram.setUser(user);
        telegramService.saveTelegram(telegram);
    }
}
