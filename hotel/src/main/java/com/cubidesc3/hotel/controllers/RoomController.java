package com.cubidesc3.hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cubidesc3.hotel.entity.Room;
import com.cubidesc3.hotel.services.RoomService;

// Con esta anotaciónes creamos los endpoints y a su vez hacemos uso de los métodos creados
// en cada una de las clases de Service
@RestController
@RequestMapping("api/Room")
public class RoomController {
    
    @Autowired
    private RoomService roomService;

    @GetMapping("/all")
    public List<Room> getAll(){

        return roomService.getAll();
        
    }

    @GetMapping("/{id}")
    public Optional<Room> getById(@PathVariable int id){

        return roomService.getById(id);
        
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Room save(@RequestBody Room c){

        return roomService.save(c);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Room update(@RequestBody Room c){

        return roomService.update(c);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){

        return roomService.delete(id);

    }


}
