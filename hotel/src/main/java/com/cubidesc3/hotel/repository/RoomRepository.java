package com.cubidesc3.hotel.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cubidesc3.hotel.entity.Room;
import com.cubidesc3.hotel.repository.crud.RoomCrudRepository;

@Repository
public class RoomRepository {
    
    @Autowired
    private RoomCrudRepository roomCrudRepository; 

    public List<Room> getAll(){
        /* 
         * Con esta función obtenemos la información de Room
        */
        return (List<Room>) roomCrudRepository.findAll();

    }

    public Optional<Room> getById(int id){
        /*
         * Con esta función encontramos el id para que nos diga si existe o no
        */
        return roomCrudRepository.findById(id);

    }

    public Room save(Room c){
        /*
         * Con esta función guardamos la información de tipo Room
        */
        return roomCrudRepository.save(c);

    }

    public void delete(Room c){
        /*
         * Con esta función eliminamos la información de una "variable"
         * de tipo Room
        */
        roomCrudRepository.delete(c);

    }
}

