package com.example.tree.entities.dtos;
import com.example.tree.entities.Farm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class TreeDto {
  private Long farmId;
  private Farm farm;
  private String type;
}
