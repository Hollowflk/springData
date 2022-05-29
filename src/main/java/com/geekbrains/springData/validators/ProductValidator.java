package com.geekbrains.springData.validators;

import com.geekbrains.springData.DTO.ProductDto;
import com.geekbrains.springData.Exceptions.ValidatorException;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {
    public void validate(ProductDto productDto){
        List<String> errors = new ArrayList<>();

        if(productDto.getCoast() < 1){
            errors.add("Цена продукта не может быть меньше 1");
        }
        if (productDto.getTitle().isBlank()){
            errors.add("Продукт не может иметь пустое название");
        }
        if (!errors.isEmpty()){
            throw new ValidatorException(errors);
        }
    }
}
