package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CompanyList  {
  
    @JsonProperty("company")
    private List<Company> company;

    public CompanyList()
    {

    }

}