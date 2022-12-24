package com.cubidesc3.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubidesc3.hotel.entity.Category;
import com.cubidesc3.hotel.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        /*
         * Con esta función obtenemos cada uno
         * de los datos que necesitamos mostrar
        */
        return categoryRepository.getAll();

    }

    public Optional<Category> getById(int id){
        /*
         * Con esta función obtenemos el id 
        */
        return categoryRepository.getById(id);

    }

    public Category save(Category c){
        /*
         * Con esta función guardamos un valor, si su
         * id existe, se guarda, sino lo devolvemos solo
        */

        if( c.getId() == null ){

            return categoryRepository.save(c);
        }

        return c;

    }


    public boolean delete(int id){
        /*
         * Con esta función eliminamos un registro a partir
         * de su id.
        */
        Optional<Category> cOp= categoryRepository.getById(id);
        if (cOp.isPresent()){
            categoryRepository.delete(cOp.get());
            return true;
        }

        return false;
    }

    public Category update(Category c){
        /*
         * Con esta función actualizamos un registro de nuestra
         * base de datos.
        */

        if (c.getId() != null){

            Optional<Category> old = categoryRepository.getById(c.getId());

            if (old.isPresent()){

                Category k = old.get();

                if (c.getName() != null) {

                    k.setName(c.getName());

                }

                if (c.getDescription() != null) {

                    k.setDescription(c.getDescription());

                }

                return categoryRepository.save(k);

            }

        }

        return c;

    }

}
