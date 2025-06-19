package com.panda.cryptoalertapp.repositories;

import com.panda.cryptoalertapp.entities.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Integer> {
}
