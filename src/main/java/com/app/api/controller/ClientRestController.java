package com.app.api.controller;

import com.app.api.entity.Client;
import com.app.api.mapper.ClientMapper;
import com.app.api.service.ClientService;
import com.app.api.util.UtilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/client")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    public ClientRestController() {
    }

    @GetMapping("/list")
    public ResponseEntity<?> list_GET()
    {
        Collection<Client> collection = clientService.findAll();
        Collection<ClientMapper> collectionMapper= UtilMapper.toClient(collection);

        if(collectionMapper.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(collectionMapper,HttpStatus.OK);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register_POST(@RequestBody Client client)
    {
        clientService.insert(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{clientId}")
    public ResponseEntity<?> edit_PUT(@RequestBody Client clientEdit,@PathVariable Integer clientId)
    {
        Client clientDb=clientService.findById(clientId);

        if(clientDb!=null)
        {
            clientDb.setBusinessname(clientEdit.getBusinessname());
            clientDb.setName(clientEdit.getName());
            clientDb.setLastname(clientEdit.getLastname());
            clientDb.setRuc(clientEdit.getRuc());
            clientDb.setAddress(clientEdit.getAddress());
            clientDb.setOffice(clientEdit.getOffice());
            clientDb.setNumber(clientEdit.getNumber());
            clientDb.setTelephone(clientEdit.getTelephone());
            clientDb.setSex(clientEdit.getSex());
            clientDb.setEmail(clientEdit.getEmail());
            clientService.update(clientDb);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/status/{clientId}")
    public ResponseEntity<?> status(@PathVariable Integer clientId,@RequestBody Client clientEdit)
    {
        Client clientDb=clientService.findById(clientId);

        if(clientDb!=null)
        {
            clientDb.setStatus(clientEdit.isStatus());
            clientService.update(clientDb);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/{clientId}")
    public ResponseEntity<?> search_GET(@PathVariable Integer clientId)
    {
        Client clientDb=clientService.findById(clientId);

        if(clientDb!=null) {
            ClientMapper mapper = new ClientMapper(clientDb);

            return new ResponseEntity<>(mapper,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<?> delete_DELETE(@PathVariable Integer clientId)
    {
        Client clientDb=clientService.findById(clientId);

        if(clientDb!=null)
        {
            clientService.delete(clientId);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, categoria no existe!",HttpStatus.NOT_FOUND);
    }
}
