package com.example.tree.services;

import com.example.tree.entities.dtos.FarmDto;
import java.util.List;


public interface FarmService {
    List<FarmDto> getAllFarms();

    FarmDto addFarm(FarmDto farmDto);

    FarmDto updateFarm(FarmDto farmDto);

    void deleteFarm(Long id);

    FarmDto getFarmById(Long id);

}
