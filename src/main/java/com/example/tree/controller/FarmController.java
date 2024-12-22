package com.example.tree.controller;

import com.example.tree.entities.dtos.FarmDto;
import com.example.tree.services.FarmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/farms")
public class FarmController {


        final private FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    // Get all farms
        @GetMapping
        public List<FarmDto> getAllFarms() {
            return farmService.getAllFarms();
        }

        // Get a farm by ID
        @GetMapping("/{id}")
        public ResponseEntity<FarmDto> getFarmById(@PathVariable Long id) {
            try {
                FarmDto farmDto = farmService.getFarmById(id);
                return ResponseEntity.ok(farmDto);
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }

        }

        // Create a new farm
        @PostMapping
        public FarmDto createFarm(@RequestBody FarmDto farm) {
            return farmService.addFarm(farm);
        }

        // Update an existing farm
        @PutMapping("/{id}")
        public ResponseEntity<FarmDto> updateFarm(@RequestBody FarmDto farmDetails) {
            try {
                FarmDto updatedFarm = farmService.updateFarm(farmDetails);
                return ResponseEntity.ok(updatedFarm);
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        // Delete a farm
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteFarm(@PathVariable Long id) {
            try {
                farmService.deleteFarm(id);
                return ResponseEntity.noContent().build();
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }
}
