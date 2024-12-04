package com.example.supermarket_system.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    private String id;
    private String name;
    private int price;
    private List<Promotion> promotions;
}
