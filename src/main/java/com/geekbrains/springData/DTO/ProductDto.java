package com.geekbrains.springData.DTO;

import com.geekbrains.springData.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Integer id;

    private String title;

    private Integer coast;

}
