package com.app.api.controller;

import com.app.api.entity.BusinessKind;
import com.app.api.mapper.BusinessMapper;
import com.app.api.service.BusinessService;
import com.app.api.util.UtilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/business")
public class BusinessRestController {

    @Autowired
    private BusinessService businessService;

    public BusinessRestController() {
    }

    @GetMapping("/list")
    public ResponseEntity<?> list_GET()
    {
        Collection<BusinessKind> collection = businessService.findAll();
        Collection<BusinessMapper> collectionMapper= UtilMapper.toBusiness(collection);

        if(collectionMapper.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(collectionMapper,HttpStatus.OK);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register_POST(@RequestBody BusinessKind businessKind)
    {
        businessService.insert(businessKind);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{businessId}")
    public ResponseEntity<?> edit_PUT(@RequestBody BusinessKind businessEdit,@PathVariable Integer businessId)
    {
        BusinessKind businessDb=businessService.findById(businessId);

        if(businessDb!=null)
        {
            businessDb.setName(businessEdit.getName());
            businessService.update(businessDb);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/{businessId}")
    public ResponseEntity<?> search_GET(@PathVariable Integer businessId)
    {
        BusinessKind businessDb=businessService.findById(businessId);

        if(businessDb!=null) {
            BusinessMapper mapper = new BusinessMapper(businessDb);

            return new ResponseEntity<>(mapper,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{businessId}")
    public ResponseEntity<?> delete_DELETE(@PathVariable Integer businessId)
    {
        BusinessKind businessDb=businessService.findById(businessId);

        if(businessDb!=null)
        {
            businessService.delete(businessId);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, categoria no existe!",HttpStatus.NOT_FOUND);
    }
}
