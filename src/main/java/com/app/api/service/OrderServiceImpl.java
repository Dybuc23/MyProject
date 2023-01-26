package com.app.api.service;

import com.app.api.entity.Order;
import com.app.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository repository;

    @Override
    public void insert(Order order) {
        repository.save(order);
    }

    @Override
    public void update(Order order) {
        repository.save(order);
    }

    @Override
    public void delete(Integer orderId) {
        repository.deleteById(orderId);
    }

    @Override
    public Order findById(Integer orderId) {
        return repository.findById(orderId).orElse(null);
    }

    @Override
    public Collection<Order> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Object[]> findAll_withProducts() {
        return repository.findAll_withProducts();
    }

    @Override
    public Collection<Object[]> findAll_withPaymentCondition() {
        return repository.findAll_withPaymentCondition();
    }
}
