package com.geekbrains.springData.Controllers;

import com.geekbrains.springData.Model.Product;
import com.geekbrains.springData.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controllers {

    private ProductService productService;

    public Controllers(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getById(id);
    }

    @GetMapping("products")
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }

    @PostMapping("products")
    public void createProduct(@RequestParam String title, @RequestParam Integer coast){
        productService.createNewProduct(title,coast);
    }

    @GetMapping("products/delete/{id}")
    public void deleteProductById(@PathVariable Integer id){
        productService.deleteById(id);
    }
}
