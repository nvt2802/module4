package com.example.repository;

import com.example.model.Settings;

public interface ISettingsRepository {
    void update(Settings settings);

    Settings getSettings();
}
