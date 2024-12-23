package com.example.tree.entities.dtos;

import com.example.tree.entities.Client;
import com.example.tree.entities.Tree;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record FarmDto(String clientId, String name,
                      double latitude,
                      double longitude,
                      Client client,
                      List<Tree> trees) {

}
