package com.example.tree.services;

import com.example.tree.entities.dtos.FarmDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FarmService {
    List<FarmDto> getAllFarms();

    FarmDto addFarm(FarmDto farmDto);

    FarmDto updateFarm(FarmDto farmDto);

    void deleteFarm(Long id);

    FarmDto getFarmById(Long id);

}
