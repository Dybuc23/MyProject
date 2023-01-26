package com.app.api.service;

import com.app.api.entity.Order;

import java.util.Collection;

public interface OrderService {

    public abstract void insert(Order order);
    public abstract void update(Order order);
    public abstract void delete(Integer orderId);
    public abstract Order findById(Integer orderId);
    public abstract Collection<Order> findAll();
    public abstract Collection<Object[]> findAll_withProducts();
    public abstract Collection<Object[]> findAll_withPaymentCondition();
}
