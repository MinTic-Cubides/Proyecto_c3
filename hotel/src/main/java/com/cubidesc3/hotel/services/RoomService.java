package com.cubidesc3.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubidesc3.hotel.entity.Room;
import com.cubidesc3.hotel.repository.RoomRepository;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;
    
    public List<Room> getAll(){
        /*
         * Con esta función obtenemos cada uno
         * de los datos que necesitamos mostrar
        */
        return roomRepository.getAll();

    }

    public Optional<Room> getById(int id){
        /*
         * Con esta función obtenemos el id 
        */
        return roomRepository.getById(id);

    }

    public Room save(Room c){
        /*
         * Con esta función guardamos un valor, si su
         * id existe, se guarda, sino lo devolvemos solo
        */

        if( c.getId() == null ){

            return roomRepository.save(c);
        }

        return c;

    }


    public boolean delete(int id){
        /*
         * Con esta función eliminamos un registro a partir
         * de su id.
        */
        Optional<Room> cOp= roomRepository.getById(id);
        if (cOp.isPresent()){
            roomRepository.delete(cOp.get());
            return true;
        }

        return false;
    }

    public Room update(Room c){
        /*
         * Con esta función actualizamos un registro de nuestra
         * base de datos.
        */

        if (c.getId() != null){

            Optional<Room> old = roomRepository.getById(c.getId());

            if (old.isPresent()){

                Room k = old.get();

                if (c.getName() != null) {

                    k.setName(c.getName());

                }

                if (c.getHotel() != null) {

                    k.setHotel(c.getHotel());

                }

                if (c.getStars() != null) {

                    k.setStars(c.getStars());

                }

                if (c.getDescription() != null) {

                    k.setDescription(c.getDescription());

                }

                return roomRepository.save(k);

            }

        }

        return c;

    }

}
