package com.app.api.controller;

import com.app.api.entity.*;
import com.app.api.service.OrderService;
import com.app.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/order_detail")
public class OrderDetailRestController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @PostMapping("/register")
    public ResponseEntity<?> register_POST(@RequestBody OrderDetails orderDetails){
        Order orderDb=orderService.findById(orderDetails.getOrder().getOrderId());
        if(orderDb!=null) {
            Product productDb=productService.findById(orderDetails.getProduct().getProductId());

            if(productDb!=null) {
                orderDb.addProduct(productDb);
                orderService.update(orderDb);

                return new ResponseEntity<>("!Item Registrado !", HttpStatus.OK);
            }

            return new ResponseEntity<>("¡Error, Product no existe!",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("¡Error, Order no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list_GET()
    {
        Collection<Object[]> collection=orderService.findAll_withProducts();

        if(collection.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(collection,HttpStatus.OK);
        }
    }
}
