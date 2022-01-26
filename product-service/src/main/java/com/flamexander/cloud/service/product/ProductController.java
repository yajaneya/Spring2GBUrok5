package com.flamexander.cloud.service.product;

import com.flamexander.cloud.common.ProductDto;
import com.flamexander.cloud.common.ProductDtoList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
//@CrossOrigin("http://localhost:3000") // Homework: *
public class ProductController {
    private final ProductService productService;

    private static final Function<Product, ProductDto> mapper = p -> new ProductDto(p.getId(), p.getTitle(), p.getPrice());

    @GetMapping
    public ProductDtoList findAll() {
        List<ProductDto> list = productService.findAll().stream().map(mapper).collect(Collectors.toList());
        return new ProductDtoList(list);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return mapper.apply(productService.findById(id).get());
    }
}
