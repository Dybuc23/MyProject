package com.app.api.controller;

import com.app.api.entity.Client;
import com.app.api.entity.Product;
import com.app.api.mapper.ProductMapper;
import com.app.api.service.ProductService;
import com.app.api.util.UtilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    public ProductRestController() {
    }

    @GetMapping("/list")
    public ResponseEntity<?> list_GET()
    {
        Collection<Product> collection = productService.findAll();
        Collection<ProductMapper> collectionMapper= UtilMapper.toProduct(collection);

        if(collectionMapper.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(collectionMapper,HttpStatus.OK);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register_POST(@RequestBody Product product)
    {
        productService.insert(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{productId}")
    public ResponseEntity<?> edit_PUT(@RequestBody Product productEdit,@PathVariable Integer productId)
    {
        Product productDb=productService.findById(productId);

        if(productDb!=null)
        {
            productDb.setName(productEdit.getName());
            productDb.setBrand(productEdit.getBrand());
            productDb.setStock(productEdit.getStock());
            productDb.setPrice(productEdit.getPrice());
            productService.update(productDb);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/status/{productId}")
    public ResponseEntity<?> status(@PathVariable Integer productId,@RequestBody Client productEdit)
    {
        Product productDb=productService.findById(productId);

        if(productDb!=null)
        {
            productDb.setStatus(productEdit.isStatus());
            productService.update(productDb);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/{productId}")
    public ResponseEntity<?> search_GET(@PathVariable Integer productId)
    {
        Product productDb=productService.findById(productId);

        if(productDb!=null) {
            ProductMapper mapper = new ProductMapper(productDb);

            return new ResponseEntity<>(mapper,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<?> delete_DELETE(@PathVariable Integer productId)
    {
        Product productDb=productService.findById(productId);

        if(productDb!=null)
        {
            productService.delete(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, categoria no existe!",HttpStatus.NOT_FOUND);
    }
}
