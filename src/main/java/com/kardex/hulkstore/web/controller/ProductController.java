package com.kardex.hulkstore.web.controller;

import com.kardex.hulkstore.domain.services.ProductService;
import com.kardex.hulkstore.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>( productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int idProduct){
        return productService.getProduct(idProduct)
            .map(
                product -> {
                return new ResponseEntity<>(product, HttpStatus.OK);
                }
            ).orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    public  ResponseEntity<List<Product>> getProductByCategory(@PathVariable("id") int idCategory){
        return productService.getProductByCategory(idCategory)
            .map(
                product -> {
                    return new ResponseEntity<>(product, HttpStatus.OK);
                }
            ).orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public  ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity deleteProductById(@PathVariable("id")  int idProduct){
        if(productService.deleteProductById(idProduct)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
