package com.kardex.hulkstore.domain.services;

import com.kardex.hulkstore.domain.Purchase;
import com.kardex.hulkstore.persistence.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String IdCustomer) {
        return purchaseRepository.getByClient(IdCustomer);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
