package com.example.security.service;


import com.example.security.entity.Province;
import com.example.security.exception.ResourceNotFoundException;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id) throws ResourceNotFoundException;

    void save(Province province);

    void remove(Long id);
}