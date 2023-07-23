package com.example.service;

import com.example.model.Products;
import java.util.List;

public interface IProductService {
    List<Products> getAll();

    boolean delete(int id);

    Products getById(int id);

    void update(Products product);

    void create(Products product);

    List<Products> search(String name);
}
