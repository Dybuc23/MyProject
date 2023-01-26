package com.app.api.service;

import com.app.api.entity.Client;

import java.util.Collection;

public interface ClientService {

    public abstract void insert(Client client);
    public abstract void update(Client client);
    public abstract void delete(Integer clientId);
    public abstract Client findById(Integer clientId);
    public abstract Collection<Client> findAll();
}
