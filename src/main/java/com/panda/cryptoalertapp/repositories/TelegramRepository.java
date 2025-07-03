package com.panda.cryptoalertapp.repositories;

import com.panda.cryptoalertapp.entities.AlertType;
import com.panda.cryptoalertapp.entities.Telegram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramRepository extends JpaRepository<Telegram, Integer> {
}
