package com.example.supermarket_system.services;

import com.example.supermarket_system.exceptions.APIException;
import com.example.supermarket_system.models.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WiremockService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RestTemplate restTemplate;

    public List<Product> getProducts(){
        String url = "http://localhost:8081/products";
        String response = restTemplate.getForObject(url, String.class);

        try {
            return objectMapper.readValue(response, new TypeReference<List<Product>>(){});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Product getProductsById(String id){
        String url = "http://localhost:8081/products/" + id;

        try {
            String response = restTemplate.getForObject(url, String.class);
            return objectMapper.readValue(response, Product.class);

        } catch (Exception e) {

            if (e instanceof HttpClientErrorException.NotFound) {
                throw new APIException(HttpStatus.NOT_FOUND, "Product not found");
            }

            throw new RuntimeException(e);
        }
    }
}
