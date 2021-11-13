package com.kardex.hulkstore.domain.services;

import com.kardex.hulkstore.domain.repository.ProductRepo;
import com.kardex.hulkstore.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAll(){
        return productRepo.getAll();
    }

    public Optional<Product> getProduct(int idProduct) {
        return productRepo.getById(idProduct);
    }

    public  Optional<List<Product>> getProductByCategory(int idCategory){
        return productRepo.getByCategory(idCategory);
    }

    public  Product saveProduct(Product product){
        return productRepo.save(product);
    }

    public  boolean deleteProductById(int idProduct){
        return getProduct(idProduct).map( product -> {
            productRepo.deleteById(idProduct);
            return true;
        }).orElse(false);

    }

    public  boolean deleteProduct(Product product){
        return getProduct(product.getIdProduct()).map( resProduct -> {
            productRepo.deleteByEntity(product);
            return true;
        }).orElse(false);
    }
}
