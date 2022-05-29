package com.geekbrains.springData.Controllers;

import com.geekbrains.springData.DTO.ProductDto;
import com.geekbrains.springData.Exceptions.ResourceNotFoundException;
import com.geekbrains.springData.Model.Product;
import com.geekbrains.springData.ProductConverter;
import com.geekbrains.springData.Service.ProductService;
import com.geekbrains.springData.validators.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;


    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Integer id){
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        return productConverter.entityToDto(product);
    }

    @GetMapping
    public Page<ProductDto> getAllProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_score", required = false) Integer minScore,
            @RequestParam(name = "max_score", required = false)Integer maxScore,
            @RequestParam(name = "name", required = false)String name){
        if(page < 1){
            page = 1;
        }
        return productService.findAll(page, minScore, maxScore, name).map(
                p -> productConverter.entityToDto(p)
        );
    }


//    @PostMapping
//    public void createProduct(@RequestParam String title, @RequestParam Integer coast){
//        productService.createNewProduct(title,coast);
//    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto){
        productValidator.validate(productDto);
        Product product = productConverter.dtoToEntity(productDto);
        product = productService.save(product);
        return productConverter.entityToDto(product);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        productValidator.validate(productDto);
        Product product = productService.update(productDto);
        return productConverter.entityToDto(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Integer id){
        productService.deleteById(id);
    }
}
