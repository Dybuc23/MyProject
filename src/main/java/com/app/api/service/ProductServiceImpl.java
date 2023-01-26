package com.app.api.service;

import com.app.api.entity.Product;
import com.app.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public void insert(Product product) {
        repository.save(product);
    }

    @Override
    public void update(Product product) {
        repository.save(product);
    }

    @Override
    public void delete(Integer productId) {
        repository.deleteById(productId);
    }

    @Override
    public Product findById(Integer productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public Collection<Product> findAll() {
        return repository.findAll();
    }
}
