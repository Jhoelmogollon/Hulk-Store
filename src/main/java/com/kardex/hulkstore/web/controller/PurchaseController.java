package com.kardex.hulkstore.web.controller;

import com.kardex.hulkstore.domain.Purchase;
import com.kardex.hulkstore.domain.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping()
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idCustomer") String idCustomer) {
        return purchaseService.getByClient(idCustomer).map(
                purchases -> new ResponseEntity<>(purchases, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
