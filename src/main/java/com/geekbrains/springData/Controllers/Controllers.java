package com.geekbrains.springData.Controllers;

import com.geekbrains.springData.DTO.ProductDto;
import com.geekbrains.springData.Model.Product;
import com.geekbrains.springData.Service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class Controllers {

    private ProductService productService;

    public Controllers(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Integer id){
        return productService.findById(id);
    }

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                        @RequestParam(name = "min_score", required = false) Integer minScore,
                                        @RequestParam(name = "max_score", required = false)Integer maxScore,
                                        @RequestParam(name = "name", required = false)String name){
        if(page < 1){
            page = 1;
        }
        return productService.find(page, maxScore, minScore, name);
    }

    @PostMapping
    public void createProduct(@RequestParam String title, @RequestParam Integer coast){
        productService.createNewProduct(title,coast);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Integer id){
        productService.deleteById(id);
    }
}
