package com.example.repository;

import com.example.model.Products;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class ProductRepository implements IProductRepository {
@PersistenceContext
private EntityManager entityManager;
    @Override
    public List<Products> getAll() {
        TypedQuery<Products> query = entityManager.createQuery("from Products",Products.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public boolean detete(int id) {
        Products products = getById(id);
        try {
            entityManager.remove(products);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public Products getById(int id) {
        return entityManager.find(Products.class,id);
    }

    @Override
    @Transactional
    public void update(Products product) {
        Products products = getById(product.getId());
        products.setName(product.getName());
        products.setDescription(product.getDescription());
        products.setAvailability(product.isAvailability());
        entityManager.merge(products);
    }

    @Override
    @Transactional
    public void add(Products product) {
        entityManager.persist(product);
    }

    @Override
    @Transactional
    public List<Products> search(String name) {
        Query query =entityManager.createNativeQuery(" select * from Products p where p.name like :name ; ",Products.class);
        query.setParameter("name","%"+name+"%");
        return query.getResultList();
    }
}
