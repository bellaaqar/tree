package com.example.tree.mappers;

import com.example.tree.entities.Tree;
import com.example.tree.entities.dtos.TreeDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TreeMapper {

    TreeDto toDto(Tree tree);
    Tree toEntity(TreeDto treeDto);

    List<TreeDto> toDtos(List<Tree> tree);
    List<Tree> toEntitites(List<TreeDto> treeDto);
}
