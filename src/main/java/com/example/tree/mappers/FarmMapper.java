package com.example.tree.mappers;

import com.example.tree.entities.Farm;
import com.example.tree.entities.dtos.FarmDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FarmMapper {
    FarmDto toDto(Farm farm);

    Farm toEntity(FarmDto farmDTO);

    List<FarmDto> toDtos(List<Farm> farm);

    List<Farm> toEntities(List<FarmDto> farmDTO);
}
