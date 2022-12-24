package com.cubidesc3.hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cubidesc3.hotel.entity.Category;
import com.cubidesc3.hotel.services.CategoryService;

// Con esta anotaciónes creamos los endpoints y a su vez hacemos uso de los métodos creados
// en cada una de las clases de Service
@RestController
@RequestMapping("api/Category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){

        return categoryService.getAll();
        
    }

    @GetMapping("/{id}")
    public Optional<Category> getById(@PathVariable int id){

        return categoryService.getById(id);
        
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category c){

        return categoryService.save(c);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category c){

        return categoryService.update(c);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){

        return categoryService.delete(id);

    }


}
