package com.cubidesc3.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubidesc3.hotel.entity.Client;
import com.cubidesc3.hotel.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        /*
         * Con esta función obtenemos cada uno
         * de los datos que necesitamos mostrar
        */
        return clientRepository.getAll();

    }

    public Optional<Client> getById(int id){
        /*
         * Con esta función obtenemos el id 
        */
        return clientRepository.getById(id);

    }

    public Client save(Client c){
        /*
         * Con esta función guardamos un valor, si su
         * id existe, se guarda, sino lo devolvemos solo
        */

        if( c.getIdClient() == null ){

            return clientRepository.save(c);
        }

        return c;

    }


    public boolean delete(int id){
        /*
         * Con esta función eliminamos un registro a partir
         * de su id.
        */
        Optional<Client> cOp= clientRepository.getById(id);
        if (cOp.isPresent()){
            clientRepository.delete(cOp.get());
            return true;
        }

        return false;
    }

    public Client update(Client c){
        /*
         * Con esta función actualizamos un registro de nuestra
         * base de datos.
        */

        if (c.getIdClient() != null){

            Optional<Client> old = clientRepository.getById(c.getIdClient());

            if (old.isPresent()){

                Client k = old.get();

                if (c.getEmail() != null) {

                    k.setEmail(c.getEmail());

                }

                if (c.getPassword() != null) {

                    k.setPassword(c.getPassword());

                }

                if (c.getName() != null) {

                    k.setName(c.getName());

                }

                if (c.getAge() != null) {

                    k.setAge(c.getAge());

                }

                return clientRepository.save(k);

            }

        }

        return c;

    }

}
