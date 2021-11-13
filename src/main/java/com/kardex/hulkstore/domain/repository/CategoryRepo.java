package com.kardex.hulkstore.domain.repository;

import com.kardex.hulkstore.persistence.crud.CategoryCRUDRepo;
import com.kardex.hulkstore.persistence.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepo {

    private CategoryCRUDRepo categoryCRUDRepo;

    public List<Category> getAll() {return (List<Category>) categoryCRUDRepo.findAll();}

    public Optional<Category> getById(int idProduct) { return categoryCRUDRepo.findById( idProduct);}

    public Optional<List<Category>> getByStatus(boolean status) {
        return categoryCRUDRepo.findByStatus(status);
    }

    public Category save(Category newCategory) {
        return categoryCRUDRepo.save(newCategory);
    }

    public void deleteById(Integer idCategory){
        categoryCRUDRepo.deleteById(idCategory);
    }

    public void deleteByEntity(Category category) {
        categoryCRUDRepo.delete(category);
    }
}
