package com.app.api.controller;

import com.app.api.entity.Order;
import com.app.api.entity.PaymentCondition;
import com.app.api.mapper.OrderMapper;
import com.app.api.mapper.PymtCondMapper;
import com.app.api.service.OrderService;
import com.app.api.service.PymtCondService;
import com.app.api.util.UtilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pymcond")
public class PaymentCondRestController {

    @Autowired
    private PymtCondService pymtCondService;

    public PaymentCondRestController() {
    }

    @GetMapping("/list")
    public ResponseEntity<?> list_GET()
    {
        Collection<PaymentCondition> collection = pymtCondService.findAll();
        Collection<PymtCondMapper> collectionMapper= UtilMapper.toPayment(collection);

        if(collectionMapper.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(collectionMapper,HttpStatus.OK);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register_POST(@RequestBody PaymentCondition pymtcond)
    {
        pymtCondService.insert(pymtcond);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{pymtcondId}")
    public ResponseEntity<?> edit_PUT(@RequestBody PaymentCondition pymtcondEdit,@PathVariable Integer pymtcondId)
    {
        PaymentCondition pymtcondDb=pymtCondService.findById(pymtcondId);

        if(pymtcondDb!=null)
        {
            pymtcondDb.setName(pymtcondEdit.getName());
            //pymtcondDb.setCondition(pymtcondEdit.getCondition());
            pymtCondService.update(pymtcondDb);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/status/{pymtcondId}")
    public ResponseEntity<?> status(@PathVariable Integer pymtcondId,@RequestBody PaymentCondition pymtcondEdit)
    {
        PaymentCondition pymtcondDb=pymtCondService.findById(pymtcondId);

        if(pymtcondDb!=null)
        {
            pymtcondDb.setStatus(pymtcondEdit.isStatus());
            pymtCondService.update(pymtcondDb);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/{pymtcondId}")
    public ResponseEntity<?> search_GET(@PathVariable Integer pymtcondId)
    {
        PaymentCondition pymtcondDb=pymtCondService.findById(pymtcondId);

        if(pymtcondDb!=null) {
            PymtCondMapper mapper = new PymtCondMapper(pymtcondDb);

            return new ResponseEntity<>(mapper,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Error, usuario no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{pymtcondId}")
    public ResponseEntity<?> delete_DELETE(@PathVariable Integer pymtcondId)
    {
        PaymentCondition pymtcondDb=pymtCondService.findById(pymtcondId);

        if(pymtcondDb!=null)
        {
            pymtCondService.delete(pymtcondId);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, categoria no existe!",HttpStatus.NOT_FOUND);
    }
}
