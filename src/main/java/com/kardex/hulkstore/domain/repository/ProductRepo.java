package com.kardex.hulkstore.domain.repository;

import com.kardex.hulkstore.persistence.crud.ProductCRUDRepo;
import com.kardex.hulkstore.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepo {

    @Autowired
    private ProductCRUDRepo productCrudRepo;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepo.findAll();
    }

    public Optional<Product> getById(int idProduct) {
        return productCrudRepo.findById(idProduct);
    }

    public Optional<List<Product>> getByCategory(int idCategory){
        return productCrudRepo.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<Product>> getStock(int stockStop){
        return productCrudRepo.findByStockLessThanAndStatus(stockStop, true);
    }

    public Product save(Product newProduct) {
        return productCrudRepo.save(newProduct);
    }

    public void deleteById(int idProduct) {
        productCrudRepo.deleteById(idProduct);
    }

    public void deleteByEntity(Product product) {
        productCrudRepo.delete(product);
    }
}
