package com.cubidesc3.hotel.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cubidesc3.hotel.entity.Category;
import com.cubidesc3.hotel.repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository categoryCrudRepository; 

    public List<Category> getAll(){
        /* 
         * Con esta función obtenemos la información de Category
        */
        return (List<Category>) categoryCrudRepository.findAll();

    }

    public Optional<Category> getById(int id){
        /*
         * Con esta función encontramos el id para que nos diga si existe o no
        */
        return categoryCrudRepository.findById(id);

    }

    public Category save(Category c){
        /*
         * Con esta función guardamos la información de tipo Category 
        */
        return categoryCrudRepository.save(c);

    }

    public void delete(Category c){
        /*
         * Con esta función eliminamos la información de una "variable"
         * de tipo Category
        */
        categoryCrudRepository.delete(c);

    }
}
