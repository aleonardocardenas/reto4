package com.grupog35.reto3.controller;

import com.grupog35.reto3.dbo.CarDbo;
import com.grupog35.reto3.dbo.ClientDbo;
import com.grupog35.reto3.model.ClientModel;
import com.grupog35.reto3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public List<ClientModel> obtener(){
        return clientService.obtener();
    }

    //Todo: Agregar el body al post porque falta el dbo
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ClientModel client){
        clientService.crear(client);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id){
        clientService.eliminar(id);
    }
    @PutMapping("/update")
    public void actualizar(@RequestBody ClientDbo clientDbo){
        clientService.actualizar(clientDbo);
    }
}
