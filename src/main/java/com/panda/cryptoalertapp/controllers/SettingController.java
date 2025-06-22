package com.panda.cryptoalertapp.controllers;

import com.panda.cryptoalertapp.entities.User;
import com.panda.cryptoalertapp.services.SettingService;
import com.panda.cryptoalertapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SettingController {
    private final UserService userService;
    private final SettingService settingService;

    public SettingController(UserService userService, SettingService settingService) {
        this.userService = userService;
        this.settingService = settingService;
    }

    @PostMapping("/saveSetting")
    public ResponseEntity<Object> saveNewSetting(@RequestParam String tgBotToken, @RequestParam double targetPrice, @RequestParam boolean isTargetUp, @RequestParam int settingOwnerId) {
        User settingOwner = userService.findUserById(settingOwnerId);
        try {
            settingService.saveSetting(tgBotToken, targetPrice, isTargetUp, settingOwner);
            return ResponseEntity.ok("New setting saved successfully...");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        }

    }
}
