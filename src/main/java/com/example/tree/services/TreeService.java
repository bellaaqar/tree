package com.example.tree.services;

import com.example.tree.entities.dtos.TreeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TreeService {

    List<TreeDto> getAllTrees();

    List<TreeDto> getAllTreesById(Long id);

    TreeDto addTree(TreeDto treeDto);

    TreeDto updateTree(TreeDto treeDto);

    void deleteTree(Long id);

}
