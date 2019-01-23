package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RelationList  {
  
    @JsonProperty("relation")
    private List<Relation> relation;

    public RelationList()
    {

    }

}