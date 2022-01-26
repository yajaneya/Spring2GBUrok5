package com.flamexander.cloud.front.service;

import com.flamexander.cloud.common.ProductDto;
import com.flamexander.cloud.common.ProductDtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@RestController

public class FrontController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/api/v1/test")
    public ProductDto test() {
        return new ProductDto(3l , "Milk", BigDecimal.valueOf(98l));
    }

    @GetMapping("/api/v1/products")
    public List<ProductDto> getProducts() {
        ProductDtoList  list = restTemplate.getForObject("http://product-service/api/v1/products", ProductDtoList.class);

        return list.getList();
    }
}
