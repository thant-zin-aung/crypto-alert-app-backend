package com.panda.cryptoalertapp.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.panda.cryptoalertapp.entities.Telegram;
import com.panda.cryptoalertapp.repositories.TelegramRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class TelegramService {
    private final TelegramRepository telegramRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public TelegramService(TelegramRepository telegramRepository) {
        this.telegramRepository = telegramRepository;
    }

    public Optional<Long> getLatestChatId(String botToken) {
        String url = String.format("https://api.telegram.org/bot%s/getUpdates", botToken);

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            JsonNode root = objectMapper.readTree(response.getBody());

            if (root.get("ok").asBoolean()) {
                JsonNode results = root.get("result");

                if (results.isArray() && results.size() > 0) {
                    // Get the latest update (last message)
                    JsonNode lastUpdate = results.get(results.size() - 1);
                    JsonNode chatIdNode = lastUpdate.at("/message/chat/id");

                    if (!chatIdNode.isMissingNode()) {
                        long chatId = chatIdNode.asLong();
                        return Optional.of(chatId);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty(); // Not found or error
    }

    public void saveTelegram(Telegram telegram) {
        telegramRepository.save(telegram);
    }
}
