package com.flamexander.cloud.common;

import java.util.List;

public class ProductDtoList {
    private List<ProductDto> list;

    public ProductDtoList(List<ProductDto> list) {
        this.list = list;
    }

    public List<ProductDto> getList() {
        return list;
    }

    public void setList(List<ProductDto> list) {
        this.list = list;
    }

    public ProductDtoList() {
    }
}
