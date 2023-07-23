package com.example.repository;

import com.example.model.Products;

import java.util.List;

public interface IProductRepository {
    List<Products> getAll();

    boolean detete(int id);

    Products getById(int id);

    void update(Products product);

    void add(Products product);

    List<Products> search(String name);
}
