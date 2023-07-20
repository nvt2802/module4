package com.example.service;

import com.example.model.Settings;

public interface ISettingsService {

    void update(Settings settings);

    Settings getSettings();
}
