package com.example.tree.services.implementation;

import com.example.tree.entities.dtos.TreeDto;
import com.example.tree.mappers.TreeMapper;
import com.example.tree.repositories.FarmRepository;
import com.example.tree.repositories.TreeRepository;
import com.example.tree.services.TreeService;

import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TreeServiceImpl implements TreeService {

    final TreeMapper treeMapper;
    final TreeRepository treeRepository;
    final FarmRepository farmRepository;

    public TreeServiceImpl(TreeMapper treeMapper, TreeRepository treeRepository, FarmRepository farmRepository) {
        this.treeMapper = treeMapper;
        this.treeRepository = treeRepository;
      this.farmRepository = farmRepository;
    }

    @Override
    public List<TreeDto> getAllTrees() {
        return treeMapper.toDtos(treeRepository.findAll());
    }

    @Override
    public List<TreeDto> getAllTreesById(Long id) {
        return treeMapper.toDtos(treeRepository.findAllById(Collections.singleton(id)));
    }

    @Override
    public TreeDto addTree(TreeDto treeDto) {
        farmRepository.findById(treeDto.getFarmId())
            .map(farmsTree -> {
                treeDto.setFarm(farmsTree);
                return treeDto;
            })
            .orElseThrow(() -> new RuntimeException("Farm not found with id: " + treeDto.getFarmId()));

        return treeMapper.toDto(treeRepository.save(treeMapper.toEntity(treeDto)));
    }

    @Override
    public TreeDto updateTree(TreeDto treeDto) {
        return treeMapper.toDto(treeRepository.save(treeMapper.toEntity(treeDto)));
    }

    @Override
    public void deleteTree(Long id) {
        treeRepository.deleteById(id);
    }
}
