package com.nexus.backend.services;


import com.nexus.backend.domain.Client;
import com.nexus.backend.domain.dtos.ClientDTO;
import com.nexus.backend.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client create(ClientDTO objDTO) {
        Client newObj = new Client(objDTO);
        return repository.save(newObj);
    }
}
