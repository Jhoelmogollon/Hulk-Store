package com.kardex.hulkstore.persistence.crud;

import com.kardex.hulkstore.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCRUDRepo extends CrudRepository<Product, Integer> {

    Optional<List<Product>> findByIdCategoryOrderByNameAsc(int idCategory);

    Optional<List<Product>> findByStockLessThanAndStatus(int stock, boolean status);
}
