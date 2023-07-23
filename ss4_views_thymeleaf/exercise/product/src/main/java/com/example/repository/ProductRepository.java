package com.example.repository;

import com.example.model.Products;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Products> productsList = new HashMap<>();
    private static int idNewProduct = 4;

    static {
        productsList.put(1, new Products(1, "Bia", 20000, "Say", true));
        productsList.put(2, new Products(2, "Ruou", 20000, "Say", false));
        productsList.put(3, new Products(3, "Moi", 20000, "Ngon", true));
        productsList.put(4, new Products(4, "Nuoc ngot", 20000, "Ngot", false));
    }

    @Override
    public List<Products> getAll() {
        return new ArrayList<>(productsList.values());
    }

    @Override
    public boolean detete(int id) {
        Products products = productsList.remove(id);
        return products != null;
    }

    @Override
    public Products getById(int id) {
        return productsList.get(id);
    }

    @Override
    public void update(Products product) {
        productsList.put(product.getId(), product);
    }

    @Override
    public void add(Products product) {
        idNewProduct++;
        product.setId(idNewProduct);
        productsList.put(idNewProduct, product);
    }

    @Override
    public List<Products> search(String name) {
        List<Products> products = new ArrayList<>();
        for (Integer key:productsList.keySet()) {
            if(productsList.get(key).getName().toLowerCase().contains(name.toLowerCase())){

                products.add(productsList.get(key));
            }
        }
        return products;
    }
}
