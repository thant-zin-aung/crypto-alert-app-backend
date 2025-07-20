package com.panda.cryptoalertapp.controllers;

import com.panda.cryptoalertapp.entities.Telegram;
import com.panda.cryptoalertapp.entities.User;
import com.panda.cryptoalertapp.services.TelegramService;
import com.panda.cryptoalertapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class AlertConfigController {
    private UserService userService;
    private TelegramService telegramService;

    public AlertConfigController(UserService userService, TelegramService telegramService) {
        this.userService = userService;
        this.telegramService = telegramService;
    }

    @PostMapping("/saveTelegramAlert")
    public ResponseEntity<Object> saveNewAlertType(@RequestParam("uid") int uid, @RequestParam("botToken") String botToken) {
        User user = userService.findUserById(uid);
        Optional<Long> chatId = telegramService.getLatestChatId(botToken);
        if(chatId.isPresent()) {
            Telegram telegram = new Telegram(botToken, chatId.get());
            telegram.setUser(user);
            telegramService.saveTelegram(telegram);
            return ResponseEntity.ok("Telegram config was saved successfully...");
        } else {
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(Map.of("error","Error on getting telegram chatId"));
        }
    }
}
