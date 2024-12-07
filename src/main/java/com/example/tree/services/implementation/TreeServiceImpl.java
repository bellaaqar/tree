package com.example.tree.services.implementation;

import com.example.tree.entities.dtos.TreeDto;
import com.example.tree.mappers.TreeMapper;
import com.example.tree.repositories.TreeRepository;
import com.example.tree.services.TreeService;

import java.util.Collections;
import java.util.List;

public class TreeServiceImpl implements TreeService {

    final TreeMapper treeMapper;
    final TreeRepository treeRepository;

    public TreeServiceImpl(TreeMapper treeMapper, TreeRepository treeRepository) {
        this.treeMapper = treeMapper;
        this.treeRepository = treeRepository;
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
