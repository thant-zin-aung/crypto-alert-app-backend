package com.panda.cryptoalertapp.controllers;

import com.panda.cryptoalertapp.entities.User;
import com.panda.cryptoalertapp.services.SettingService;
import com.panda.cryptoalertapp.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingController {
    private UserService userService;
    private SettingService settingService;

    public SettingController(UserService userService, SettingService settingService) {
        this.userService = userService;
        this.settingService = settingService;
    }

    @PostMapping("/saveSetting")
    public ResponseEntity<Object> saveNewSetting(@RequestParam String tgBotToken, @RequestParam double targetPrice, @RequestParam boolean isTargetUp, @RequestParam boolean isTargetHit, @RequestParam int settingOwnerId) {
        User settingOwner = userService.findUserById(settingOwnerId);
        settingService.saveSetting(tgBotToken, targetPrice, isTargetUp, isTargetHit, settingOwner);
        return ResponseEntity.ok("New setting saved successfully...");
    }
}
