package com.cubidesc3.hotel.repository.crud;

import org.springframework.data.repository.CrudRepository;
import com.cubidesc3.hotel.entity.Reservation;

// importamos el repositorio que necesitamos por parte de nuestro framework
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
}

