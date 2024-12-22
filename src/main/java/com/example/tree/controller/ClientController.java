package com.example.tree.controller;
import com.example.tree.entities.Client;
import com.example.tree.entities.dtos.ClientDto;
import com.example.tree.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {


    final private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Get all clients
    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    // Get a client by ID
    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    // Create a new client
    @PostMapping
    public ClientDto createClient(@RequestBody ClientDto client) {
        return clientService.addClient(client);
    }

    // Update an existing client
    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDetails) {
        try {
            ClientDto updatedClient = clientService.updateClient(clientDetails);
            return ResponseEntity.ok(updatedClient);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a client
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
