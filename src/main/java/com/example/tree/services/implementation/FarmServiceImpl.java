package com.example.tree.services.implementation;

import com.example.tree.entities.dtos.FarmDto;
import com.example.tree.mappers.FarmMapper;
import com.example.tree.repositories.FarmRepository;
import com.example.tree.services.FarmService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FarmServiceImpl implements FarmService {

    final FarmMapper farmMapper;
    final FarmRepository farmRepository;

    public FarmServiceImpl(FarmMapper farmMapper, FarmRepository farmRepository) {
        this.farmMapper = farmMapper;
        this.farmRepository = farmRepository;
    }

    @Override
    public List<FarmDto> getAllFarms() {
        return farmMapper.toDtos(farmRepository.findAll());
    }

    @Override
    @Transactional
    public FarmDto addFarm(FarmDto farmDto) {
        return farmMapper.toDto(farmRepository.save(farmMapper.toEntity(farmDto)));
    }

    @Override
    @Transactional
    public FarmDto updateFarm(FarmDto farmDto) {
         return farmMapper.toDto(farmRepository.save(farmMapper.toEntity(farmDto)));
    }

    @Override
    public void deleteFarm(Long id) {
        farmRepository.deleteById(id);
    }
}
