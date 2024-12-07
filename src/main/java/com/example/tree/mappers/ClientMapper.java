package com.example.tree.mappers;

import com.example.tree.entities.Client;
import com.example.tree.entities.dtos.ClientDto;
import org.mapstruct.Mapper;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto(Client client);
    Client toEntity(ClientDto clientDto);

    List<ClientDto> toDtos( List<Client> client);
    List<Client> toEntities(List<ClientDto> clientDto);
}
