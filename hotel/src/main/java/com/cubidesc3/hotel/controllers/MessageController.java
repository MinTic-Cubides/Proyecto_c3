package com.cubidesc3.hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cubidesc3.hotel.entity.Message;
import com.cubidesc3.hotel.services.MessageService;

// Con esta anotaciónes creamos los endpoints y a su vez hacemos uso de los métodos creados
// en cada una de las clases de Service
@RestController
@RequestMapping("api/Message")
public class MessageController {
    
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){

        return messageService.getAll();
        
    }

    @GetMapping("/{id}")
    public Optional<Message> getById(@PathVariable int id){

        return messageService.getById(id);
        
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message c){

        return messageService.save(c);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message c){

        return messageService.update(c);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){

        return messageService.delete(id);

    }


}
