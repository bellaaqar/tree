package com.example.tree.entities.dtos;

import com.example.tree.entities.Client;
import com.example.tree.entities.Tree;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmDto {
  private Long clientId;
  private String name;
  private double latitude;
  private double longitude;
  private Client client;
  private List<Tree> trees;
}
