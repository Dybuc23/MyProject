package com.app.api.service;

import com.app.api.entity.PaymentCondition;

import java.util.Collection;

public interface PymtCondService {

    public abstract void insert(PaymentCondition paymentCondition);
    public abstract void update(PaymentCondition paymentCondition);
    public abstract void delete(Integer pytcoID);
    public abstract PaymentCondition findById(Integer pytcoID);
    public abstract Collection<PaymentCondition> findAll();
}
