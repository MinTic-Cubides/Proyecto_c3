package com.cubidesc3.hotel.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cubidesc3.hotel.entity.Score;
import com.cubidesc3.hotel.repository.crud.ScoreCrudRepository;

@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudRepository; 

    public List<Score> getAll(){
        /* 
         * Con esta función obtenemos la información de Score
        */
        return (List<Score>) scoreCrudRepository.findAll();

    }

    public Optional<Score> getById(int id){
        /*
         * Con esta función encontramos el id para que nos diga si existe o no
        */
        return scoreCrudRepository.findById(id);

    }

    public Score save(Score c){
        /*
         * Con esta función guardamos la información de tipo Score
        */
        return scoreCrudRepository.save(c);

    }

    public void delete(Score c){
        /*
         * Con esta función eliminamos la información de una "variable"
         * de tipo Score
        */
        scoreCrudRepository.delete(c);

    }
}
