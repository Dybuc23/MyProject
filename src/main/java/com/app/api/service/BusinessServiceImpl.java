package com.app.api.service;

import com.app.api.entity.BusinessKind;
import com.app.api.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BusinessServiceImpl implements BusinessService{

    @Autowired
    private BusinessRepository repository;
    @Override
    public void insert(BusinessKind businessKind) {
        repository.save(businessKind);
    }

    @Override
    public void update(BusinessKind businessKind) {
        repository.save(businessKind);
    }

    @Override
    public void delete(Integer businessId) {
        repository.deleteById(businessId);
    }

    @Override
    public BusinessKind findById(Integer businessId) {
        return repository.findById(businessId).orElse(null);
    }

    @Override
    public Collection<BusinessKind> findAll() {
        return repository.findAll();
    }
}
