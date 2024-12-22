package com.example.tree.services.implementation;

import com.example.tree.entities.dtos.ClientDto;
import com.example.tree.mappers.ClientMapper;
import com.example.tree.repositories.ClientRepository;
import com.example.tree.services.ClientService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    final ClientMapper clientMapper;
    final ClientRepository clientRepository;

    public ClientServiceImpl(ClientMapper clientMapper, ClientRepository clientRepository) {
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDto> getAllClients() {
        return clientMapper.toDtos(clientRepository.findAll());
    }

    @Override
    @Transactional
    public ClientDto addClient(ClientDto clientDto) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(clientDto)));
    }

    @Override
    public ClientDto getClientById(Long id) {
        return clientMapper.toDto(clientRepository.findById(id).orElseThrow());
    }

    @Override
    @Transactional
    public ClientDto updateClient(ClientDto clientDto) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(clientDto)));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
