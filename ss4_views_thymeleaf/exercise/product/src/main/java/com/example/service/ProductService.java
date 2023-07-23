package com.example.service;

import com.example.model.Products;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;


    @Override
    public List<Products> getAll() {
        return productRepository.getAll();
    }

    @Override
    public boolean delete(int id) {
        return productRepository.detete(id);
    }

    @Override
    public Products getById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public void update(Products product) {
        productRepository.update(product);
    }

    @Override
    public void create(Products product) {
        productRepository.add(product);
    }

    @Override
    public List<Products> search(String name) {
        return productRepository.search(name);
    }
}
