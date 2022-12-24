package com.cubidesc3.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubidesc3.hotel.entity.Reservation;
import com.cubidesc3.hotel.repository.ReservationRepository;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        /*
         * Con esta función obtenemos cada uno
         * de los datos que necesitamos mostrar
        */
        return reservationRepository.getAll();

    }

    public Optional<Reservation> getById(int id){
        /*
         * Con esta función obtenemos el id 
        */
        return reservationRepository.getById(id);

    }

    public Reservation save(Reservation c){
        /*
         * Con esta función guardamos un valor, si su
         * id existe, se guarda, sino lo devolvemos solo
        */

        if( c.getIdReservation() == null ){

            return reservationRepository.save(c);
        }

        return c;

    }


    public boolean delete(int id){
        /*
         * Con esta función eliminamos un registro a partir
         * de su id.
        */
        Optional<Reservation> cOp= reservationRepository.getById(id);
        if (cOp.isPresent()){
            reservationRepository.delete(cOp.get());
            return true;
        }

        return false;
    }

    public Reservation update(Reservation c){
        /*
         * Con esta función actualizamos un registro de nuestra
         * base de datos.
        */

        if (c.getIdReservation() != null){

            Optional<Reservation> old = reservationRepository.getById(c.getIdReservation());

            if (old.isPresent()){

                Reservation k = old.get();

                if (c.getStartDate() != null) {

                    k.setStartDate(c.getStartDate());

                }

                if (c.getDevolutionDate() != null) {

                    k.setDevolutionDate(c.getDevolutionDate());

                }

                k.setStatus("updated");

                return reservationRepository.save(k);

            }

        }

        return c;

    }

}
