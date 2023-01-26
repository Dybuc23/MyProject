package com.app.api.controller;

import com.app.api.entity.Order;
import com.app.api.mapper.OrderMapper;
import com.app.api.service.OrderService;
import com.app.api.util.UtilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    @Autowired
    private OrderService orderService;



    @GetMapping("/list")
    public ResponseEntity<?> list_GET()
    {
        Collection<Order> collection = orderService.findAll();
        //Collection<Object[]> collection=orderService.findAll_withPaymentCondition();
        Collection<OrderMapper> collectionMapper= UtilMapper.toOrder(collection);

        if(collectionMapper.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(collectionMapper,HttpStatus.OK);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register_POST(@RequestBody Order order)
    {
        orderService.insert(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{orderId}")
    public ResponseEntity<?> edit_PUT(@RequestBody Order orderEdit,@PathVariable Integer orderId)
    {
        Order orderDb=orderService.findById(orderId);

        if(orderDb!=null)
        {
            orderDb.setPaydocument(orderEdit.getPaydocument());
            //orderDb.
            orderService.update(orderDb);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/status/{orderId}")
    public ResponseEntity<?> status(@PathVariable Integer orderId,@RequestBody Order orderEdit)
    {
        Order orderDb=orderService.findById(orderId);

        if(orderDb!=null)
        {
            orderDb.setStatus(orderEdit.isStatus());
            orderService.update(orderDb);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/{orderId}")
    public ResponseEntity<?> search_GET(@PathVariable Integer orderId)
    {
        Order orderDb=orderService.findById(orderId);

        if(orderDb!=null) {
            OrderMapper mapper = new OrderMapper(orderDb);

            return new ResponseEntity<>(mapper,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<?> delete_DELETE(@PathVariable Integer orderId)
    {
        Order orderDb=orderService.findById(orderId);

        if(orderDb!=null)
        {
            orderService.delete(orderId);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, categoria no existe!",HttpStatus.NOT_FOUND);
    }
}
