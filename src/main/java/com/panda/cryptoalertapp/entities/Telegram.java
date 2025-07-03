package com.panda.cryptoalertapp.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Telegram extends AlertType {

    private String botToken;
    private long chatId;

    public Telegram() {
    }

    public Telegram(String botToken, long chatId) {
        this.botToken = botToken;
        this.chatId = chatId;
    }

    public String getBotToken() {
        return botToken;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }
}
