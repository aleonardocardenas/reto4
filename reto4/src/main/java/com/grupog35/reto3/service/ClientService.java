package com.grupog35.reto3.service;

import com.grupog35.reto3.dbo.CarDbo;
import com.grupog35.reto3.dbo.ClientDbo;
import com.grupog35.reto3.model.CarModel;
import com.grupog35.reto3.model.ClientModel;
import com.grupog35.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientModel> obtener(){
        return clientRepository.findAll();
    }

    public void crear(ClientModel model){
        if(!clientRepository.existsById(model.getIdClient())){
            clientRepository.save(model);
        }
    }

    public void eliminar(int id){
        clientRepository.deleteById(id);
    }
    public void actualizar(ClientDbo clientDbo){
        if(clientRepository.existsById(clientDbo.getIdClient())){
            ClientModel client = clientRepository.findById((clientDbo.getIdClient())).get();
            client.setIdClient(clientDbo.getIdClient());
            client.setEmail(clientDbo.getEmail());
            client.setPassword(clientDbo.getPassword());
            client.setName(clientDbo.getName());
            client.setAge(clientDbo.getAge());
            clientRepository.save(client);
        }
    }
}
