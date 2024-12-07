package com.example.tree.mappers;

import com.example.tree.entities.Farm;
import com.example.tree.entities.dtos.FarmDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FarmMapper {
    @Mapping(source = "client.id", target = "clientId") // Map nested client ID
    FarmDto toDto(Farm farm);

    @Mapping(source = "clientId", target = "client.id") // Map clientId to nested client object
    Farm toEntity(FarmDto farmDTO);

    @Mapping(source = "client.id", target = "clientId") // Map nested client ID
    List<FarmDto> toDtos(List<Farm> farm);

    @Mapping(source = "clientId", target = "client.id") // Map clientId to nested client object
    List<Farm> toEntities(List<FarmDto> farmDTO);
}
