package com.example.validate_song.service;

import com.example.validate_song.model.Song;
import com.example.validate_song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> getAll() {
        return songRepository.findAll();
    }

    @Override
    public void add(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song getById(int id) {
        return songRepository.findById(id).get();
    }
}
