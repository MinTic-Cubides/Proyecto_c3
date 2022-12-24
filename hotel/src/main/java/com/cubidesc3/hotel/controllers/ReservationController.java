package com.cubidesc3.hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cubidesc3.hotel.entity.Reservation;
import com.cubidesc3.hotel.services.ReservationService;

// Con esta anotaciónes creamos los endpoints y a su vez hacemos uso de los métodos creados
// en cada una de las clases de Service
@RestController
@RequestMapping("api/Reservation")
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){

        return reservationService.getAll();
        
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getById(@PathVariable int id){

        return reservationService.getById(id);
        
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation c){

        return reservationService.save(c);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation c){

        return reservationService.update(c);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){

        return reservationService.delete(id);

    }


}
