package com.geekbrains.springData.DTO;

import com.geekbrains.springData.Model.Product;

public class ProductDto {

    private String title;

    private Integer coast;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCoast() {
        return coast;
    }

    public void setCoast(Integer coast) {
        this.coast = coast;
    }

    public ProductDto(Product product){
        this.title = product.getTitle();
        this.coast = product.getCoast();
    }

    public ProductDto() {
    }
}
