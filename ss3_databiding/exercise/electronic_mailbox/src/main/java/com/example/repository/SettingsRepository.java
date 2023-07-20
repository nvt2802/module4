package com.example.repository;

import com.example.model.Settings;
import org.springframework.stereotype.Repository;

@Repository
public class SettingsRepository implements ISettingsRepository {
    private static Settings settingsRepo = new Settings();
    static {
        settingsRepo.setLanguages("English");
        settingsRepo.setPageSize(5);
        settingsRepo.setSpamsFilter(true);
        settingsRepo.setSignature("Tan\nTan Tan");
    }

    @Override
    public void update(Settings settings) {
        settingsRepo = settings;
    }

    @Override
    public Settings getSettings() {
        return settingsRepo;
    }
}
