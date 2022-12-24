package com.cubidesc3.hotel.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubidesc3.hotel.entity.Score;
import com.cubidesc3.hotel.repository.ScoreRepository;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll(){
        /*
         * Con esta función obtenemos cada uno
         * de los datos que necesitamos mostrar
        */
        return scoreRepository.getAll();

    }

    public Optional<Score> getById(int id){
        /*
         * Con esta función obtenemos el id 
        */
        return scoreRepository.getById(id);

    }

    public Score save(Score c){
        /*
         * Con esta función guardamos un valor, si su
         * id existe, se guarda, sino lo devolvemos solo
        */

        if( c.getIdScore() == null ){

            return scoreRepository.save(c);
        }

        return c;

    }


    public boolean delete(int id){
        /*
         * Con esta función eliminamos un registro a partir
         * de su id.
        */
        Optional<Score> cOp= scoreRepository.getById(id);
        if (cOp.isPresent()){
            scoreRepository.delete(cOp.get());
            return true;
        }

        return false;
    }

    public Score update(Score c){
        /*
         * Con esta función actualizamos un registro de nuestra
         * base de datos.
        */

        if (c.getIdScore() != null){

            Optional<Score> old = scoreRepository.getById(c.getIdScore());

            if (old.isPresent()){

                Score k = old.get();

                if (c.getScore() != null) {

                    k.setScore(c.getScore());

                }

                return scoreRepository.save(k);

            }

        }

        return c;

    }

}
