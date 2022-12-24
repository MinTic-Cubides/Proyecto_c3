package com.cubidesc3.hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cubidesc3.hotel.entity.Client;
import com.cubidesc3.hotel.services.ClientService;

// Con esta anotaciónes creamos los endpoints y a su vez hacemos uso de los métodos creados
// en cada una de las clases de Service
@RestController
@RequestMapping("api/Client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){

        return clientService.getAll();
        
    }

    @GetMapping("/{id}")
    public Optional<Client> getById(@PathVariable int id){

        return clientService.getById(id);
        
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client c){

        return clientService.save(c);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client c){

        return clientService.update(c);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){

        return clientService.delete(id);

    }
}
