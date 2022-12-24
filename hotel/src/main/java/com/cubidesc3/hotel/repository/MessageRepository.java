package com.cubidesc3.hotel.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cubidesc3.hotel.entity.Message;
import com.cubidesc3.hotel.repository.crud.MessageCrudRepository;

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository; 

    public List<Message> getAll(){
        /* 
         * Con esta función obtenemos la información de Message
        */
        return (List<Message>) messageCrudRepository.findAll();

    }

    public Optional<Message> getById(int id){
        /*
         * Con esta función encontramos el id para que nos diga si existe o no
        */
        return messageCrudRepository.findById(id);

    }

    public Message save(Message c){
        /*
         * Con esta función guardamos la información de tipo Message
        */
        return messageCrudRepository.save(c);

    }

    public void delete(Message c){
        /*
         * Con esta función eliminamos la información de una "variable"
         * de tipo Message
        */
        messageCrudRepository.delete(c);

    }
}
