package com.cubidesc3.hotel.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cubidesc3.hotel.entity.Reservation;
import com.cubidesc3.hotel.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository; 

    public List<Reservation> getAll(){
        /* 
         * Con esta función obtenemos la información de Reservation
        */
        return (List<Reservation>) reservationCrudRepository.findAll();

    }

    public Optional<Reservation> getById(int id){
        /*
         * Con esta función encontramos el id para que nos diga si existe o no
        */
        return reservationCrudRepository.findById(id);

    }

    public Reservation save(Reservation c){
        /*
         * Con esta función guardamos la información de tipo Reservation
        */
        return reservationCrudRepository.save(c);

    }

    public void delete(Reservation c){
        /*
         * Con esta función eliminamos la información de una "variable"
         * de tipo Reservation
        */
        reservationCrudRepository.delete(c);

    }
}
