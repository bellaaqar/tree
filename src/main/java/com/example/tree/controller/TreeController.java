package com.example.tree.controller;

import com.example.tree.entities.dtos.TreeDto;
import com.example.tree.services.TreeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
public class TreeController {

    final private TreeService treeService;

    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    // Get all trees
    @GetMapping
    public List<TreeDto> getAllTrees() {
        return treeService.getAllTrees();
    }

    // Get a tree by ID
    @GetMapping("/{id}")
    public ResponseEntity<List<TreeDto>> getTreesById(@PathVariable Long id) {
        try {
            List<TreeDto> trees = treeService.getAllTreesById(id);
            return ResponseEntity.ok(trees);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

    // Create a new tree
    @PostMapping
    public TreeDto createTree(@RequestBody TreeDto tree) {
        return treeService.addTree(tree);
    }

    // Update an existing tree
    @PutMapping("/{id}")
    public ResponseEntity<TreeDto> updateTree(@RequestBody TreeDto treeDetails) {
        try {
            TreeDto  updatedTree = treeService.updateTree(treeDetails);
            return ResponseEntity.ok(updatedTree);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a tree
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTree(@PathVariable Long id) {
        try {
            treeService.deleteTree(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
