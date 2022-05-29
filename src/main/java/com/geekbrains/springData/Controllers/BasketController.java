package com.geekbrains.springData.Controllers;

import com.geekbrains.springData.Exceptions.ResourceNotFoundException;
import com.geekbrains.springData.Model.Product;
import com.geekbrains.springData.ProductConverter;
import com.geekbrains.springData.Repository.ProductRepository;
import com.geekbrains.springData.Service.BasketService;
import com.geekbrains.springData.Service.ProductService;
import com.geekbrains.springData.validators.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;
    private final ProductRepository productRepository;

    @GetMapping("/{id}")
    public void addToBasket(@PathVariable Integer id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        basketService.addProduct(product);
    }

    @GetMapping
    public List<Product> getBasketList(){
        return basketService.getBasketList();
    }

    @DeleteMapping("/{id}")
    public void removeFromBasket(@PathVariable Integer id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        basketService.deleteProduct(product);
    }
}
