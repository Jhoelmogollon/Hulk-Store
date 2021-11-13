package com.kardex.hulkstore.persistence.crud;

import com.kardex.hulkstore.persistence.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryCRUDRepo extends CrudRepository<Category, Integer> {

    Optional<List<Category>> findByStatus(boolean status);
}
