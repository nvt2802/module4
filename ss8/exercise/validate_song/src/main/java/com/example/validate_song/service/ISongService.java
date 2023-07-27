package com.example.validate_song.service;

import com.example.validate_song.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAll();

    void add(Song song);

    Song getById(int id);
}
