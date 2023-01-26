package com.app.api.service;

import com.app.api.entity.PaymentCondition;
import com.app.api.repository.PymtCondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PymtCondServiceImpl implements PymtCondService{

    @Autowired
    private PymtCondRepository repository;

    @Override
    public void insert(PaymentCondition paymentCondition) {
        repository.save(paymentCondition);
    }

    @Override
    public void update(PaymentCondition paymentCondition) {
        repository.save(paymentCondition);
    }

    @Override
    public void delete(Integer pytcoID) {
        repository.deleteById(pytcoID);
    }

    @Override
    public PaymentCondition findById(Integer pytcoID) {
        return repository.findById(pytcoID).orElse(null);
    }

    @Override
    public Collection<PaymentCondition> findAll() {
        return repository.findAll();
    }
}
