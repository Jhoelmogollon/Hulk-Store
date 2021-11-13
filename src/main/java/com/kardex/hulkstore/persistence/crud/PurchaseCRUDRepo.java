package com.kardex.hulkstore.persistence.crud;

import com.kardex.hulkstore.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCRUDRepo extends CrudRepository<Purchase, Integer> {

    Optional<List<Purchase>> findByIdCustomer(String idCustomer);
}
