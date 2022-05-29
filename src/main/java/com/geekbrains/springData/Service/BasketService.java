package com.geekbrains.springData.Service;

import com.geekbrains.springData.Model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final List<Product> basket = new ArrayList<>();

    public void addProduct(Product product){
        basket.add(product);
    }

    public void deleteProduct(Product product){
        basket.remove(product);
    }

    public List<Product> getBasketList(){
        return basket;
    }
}
