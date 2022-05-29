package com.geekbrains.springData;

import com.geekbrains.springData.DTO.ProductDto;
import com.geekbrains.springData.Model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto productDto){
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getCoast());
    }

    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(), product.getTitle(), product.getCoast());
    }
}
