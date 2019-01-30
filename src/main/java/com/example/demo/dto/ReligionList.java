package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReligionList  {
  
    @JsonProperty("religion")
    private List<Religion> religion;

    public ReligionList()
    {

    }

}