package com.app.api.service;

import com.app.api.entity.Client;
import com.app.api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository repository;

    @Override
    @Transactional
    public void insert(Client client) {
        repository.save(client);
    }

    @Override
    public void update(Client client) {
        repository.save(client);
    }

    @Override
    public void delete(Integer clientId) {

        repository.deleteById(clientId);
    }

    @Override
    public Client findById(Integer clientId) {
        return repository.findById(clientId).orElse(null);
    }

    @Override
    public Collection<Client> findAll() {
        return repository.findAll();
    }
}
