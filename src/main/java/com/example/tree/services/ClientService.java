package com.example.tree.services;

import com.example.tree.entities.dtos.ClientDto;
import java.util.List;

public interface ClientService {
    List<ClientDto> getAllClients();
    ClientDto addClient(ClientDto clientDto);
    ClientDto getClientById(Long id);
    ClientDto updateClient(ClientDto clientDto);
    void deleteClient(Long id);
}
