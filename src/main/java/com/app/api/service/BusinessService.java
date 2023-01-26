package com.app.api.service;


import com.app.api.entity.BusinessKind;

import java.util.Collection;

public interface BusinessService {

    public abstract void insert(BusinessKind businessKind);
    public abstract void update(BusinessKind businessKind);
    public abstract void delete(Integer businessId);
    public abstract BusinessKind findById(Integer businessId);
    //public abstract BusinessKind findByUsername(String username);
    public abstract Collection<BusinessKind> findAll();
}
