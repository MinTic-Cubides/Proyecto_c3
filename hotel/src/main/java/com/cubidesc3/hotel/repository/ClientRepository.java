package com.cubidesc3.hotel.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cubidesc3.hotel.entity.Client;
import com.cubidesc3.hotel.repository.crud.ClientCrudRepository;

@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clientCrudRepository; 

    public List<Client> getAll(){
        /* 
         * Con esta función obtenemos la información de Client
        */
        return (List<Client>) clientCrudRepository.findAll();

    }

    public Optional<Client> getById(int id){
        /*
         * Con esta función encontramos el id para que nos diga si existe o no
        */
        return clientCrudRepository.findById(id);

    }

    public Client save(Client c){
        /*
         * Con esta función guardamos la información de tipo Category 
        */
        return clientCrudRepository.save(c);

    }

    public void delete(Client c){
        /*
         * Con esta función eliminamos la información de una "variable"
         * de tipo Client
        */
        clientCrudRepository.delete(c);

    }
}
