package com.app.api.service;

import com.app.api.entity.Product;

import java.util.Collection;

public interface ProductService {

    public abstract void insert(Product product);
    public abstract void update(Product product);
    public abstract void delete(Integer productId);
    public abstract Product findById(Integer productId);
    public abstract Collection<Product> findAll();
}
