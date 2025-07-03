package com.panda.cryptoalertapp.services;

import com.panda.cryptoalertapp.entities.AlertType;
import com.panda.cryptoalertapp.entities.Setting;
import com.panda.cryptoalertapp.entities.Telegram;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PriceCheckService {

    private final SettingService settingService;
    private List<Setting> listOfSetting;
    public PriceCheckService(SettingService settingService) {
        this.settingService = settingService;
        listOfSetting = settingService.getAllSetting();
    }

    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 1000)
    public void checkPriceAndNotify() {
        double currentPrice = fetchCurrentBTCPrice();
        listOfSetting.forEach(setting -> {
            if((setting.getTargetPrice() < currentPrice && setting.isTargetUp() && !setting.isTargetHit()) ||
                    setting.getTargetPrice() > currentPrice && !setting.isTargetUp() && !setting.isTargetHit()) {
//                sendTelegramMessage(setting.getTgBotToken(), String.valueOf(setting.getTgChatId()), currentPrice);
                setting.getAlertTypes().forEach(alertType -> {
                    if(alertType instanceof Telegram telegram) {
                        sendTelegramMessage(telegram.getBotToken(), String.valueOf(telegram.getChatId()), currentPrice);
                    }
                });
                setting.setTargetHit(true);
                try {
                    settingService.updateSetting(setting);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private double fetchCurrentBTCPrice() {
        String url = "https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT";
        Map<String, String> response = restTemplate.getForObject(url, Map.class);
        return Double.parseDouble(response.get("price"));
    }

    private void sendTelegramMessage(String botToken, String chatId, double price) {
        String url = String.format("https://api.telegram.org/bot%s/sendMessage", botToken);

        Map<String, Object> body = new HashMap<>();
        body.put("chat_id", chatId);
        body.put("text", "🎯 BTC hit your target! Current price: $" + price);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        try {
            restTemplate.postForObject(url, request, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
