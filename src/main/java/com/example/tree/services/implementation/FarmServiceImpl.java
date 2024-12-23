package com.example.tree.services.implementation;

import com.example.tree.entities.Client;
import com.example.tree.entities.dtos.FarmDto;
import com.example.tree.mappers.FarmMapper;
import com.example.tree.repositories.ClientRepository;
import com.example.tree.repositories.FarmRepository;
import com.example.tree.services.FarmService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FarmServiceImpl implements FarmService {

    final FarmMapper farmMapper;
    final FarmRepository farmRepository;
    final ClientRepository clientRepository;

    public FarmServiceImpl(FarmMapper farmMapper, FarmRepository farmRepository, ClientRepository clientRepository) {
        this.farmMapper = farmMapper;
        this.farmRepository = farmRepository;
      this.clientRepository = clientRepository;
    }

    @Override
    public List<FarmDto> getAllFarms() {
        return farmMapper.toDtos(farmRepository.findAll());
    }

    @Override
    @Transactional
    public FarmDto addFarm(FarmDto farmDto) {
        clientRepository.findById(farmDto.getClientId())
            .map(farmsClient -> {
                farmDto.setClient(farmsClient);
                return farmDto;
            })
            .orElseThrow(() -> new RuntimeException("Client not found with id: " + farmDto.getClientId()));

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

    @Override
    public FarmDto getFarmById(Long id) {
        return farmMapper.toDto(farmRepository.findById(id).orElseThrow());
    }
}
