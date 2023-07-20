package com.example.service;

import com.example.model.Settings;
import com.example.repository.ISettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService implements ISettingsService {
    @Autowired
    private ISettingsRepository settingsRepository;

    @Override
    public void update(Settings settings) {
        settingsRepository.update(settings);
    }

    @Override
    public Settings getSettings() {
        return settingsRepository.getSettings();
    }
}
