package com.cubidesc3.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubidesc3.hotel.entity.Message;
import com.cubidesc3.hotel.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        /*
         * Con esta función obtenemos cada uno
         * de los datos que necesitamos mostrar
        */
        return messageRepository.getAll();

    }

    public Optional<Message> getById(int id){
        /*
         * Con esta función obtenemos el id 
        */
        return messageRepository.getById(id);

    }

    public Message save(Message c){
        /*
         * Con esta función guardamos un valor, si su
         * id existe, se guarda, sino lo devolvemos solo
        */

        if( c.getIdMessage() == null ){

            return messageRepository.save(c);
        }

        return c;

    }


    public boolean delete(int id){
        /*
         * Con esta función eliminamos un registro a partir
         * de su id.
        */
        Optional<Message> cOp= messageRepository.getById(id);
        if (cOp.isPresent()){
            messageRepository.delete(cOp.get());
            return true;
        }

        return false;
    }

    public Message update(Message c){
        /*
         * Con esta función actualizamos un registro de nuestra
         * base de datos.
        */

        if (c.getIdMessage() != null){

            Optional<Message> old = messageRepository.getById(c.getIdMessage());

            if (old.isPresent()) {

                Message k = old.get();

                if (c.getMessageText() != null) {

                    k.setMessageText(c.getMessageText());

                }

                return messageRepository.save(k);

            }

        }

        return c;

    }

}
