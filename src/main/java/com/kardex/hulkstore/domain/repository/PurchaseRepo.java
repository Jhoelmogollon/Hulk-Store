package com.kardex.hulkstore.domain.repository;

import com.kardex.hulkstore.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepo {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String idCustomer);
    Purchase save(Purchase purchase);
}
