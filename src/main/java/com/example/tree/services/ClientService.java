package com.example.tree.services;

import com.example.tree.entities.Client;
import com.example.tree.entities.dtos.ClientDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClientService {
    List<ClientDto> getAllClients();
    ClientDto addClient(ClientDto clientDto);
    ClientDto updateClient(ClientDto clientDto);
    void deleteClient(Long id);
}
