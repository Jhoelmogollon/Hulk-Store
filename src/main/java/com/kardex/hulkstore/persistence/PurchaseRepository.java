package com.kardex.hulkstore.persistence;

import com.kardex.hulkstore.domain.Purchase;
import com.kardex.hulkstore.domain.repository.PurchaseRepo;
import com.kardex.hulkstore.persistence.crud.PurchaseCRUDRepo;
import com.kardex.hulkstore.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements PurchaseRepo {

    @Autowired
    private PurchaseCRUDRepo purchaseCRUDRepo;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchasesDomain((List<com.kardex.hulkstore.persistence.entity.Purchase>) purchaseCRUDRepo.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String idCustomer) {
        return purchaseCRUDRepo.findByIdCustomer(idCustomer)
            .map(purchases -> purchaseMapper.toPurchasesDomain(purchases));
    }

    @Override
    public Purchase save(Purchase purchase) {
        com.kardex.hulkstore.persistence.entity.Purchase purchase1 = purchaseMapper.toPurchaseEntity(purchase);
        purchase1.getProducts().forEach( product -> product.setSell(purchase1));
        return purchaseMapper.toPurchaseDomain(purchaseCRUDRepo.save(purchase1));
    }
}
