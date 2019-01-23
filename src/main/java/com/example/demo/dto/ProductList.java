package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductList  {
  
    @JsonProperty("products")
    private List<Product> products;

    public ProductList()
    {

    }

}