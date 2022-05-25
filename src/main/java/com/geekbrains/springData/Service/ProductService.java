package com.geekbrains.springData.Service;

import com.geekbrains.springData.Repository.ProductRepository;
import com.geekbrains.springData.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getById(Integer id){
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public void createNewProduct(String title, Integer coast){
        productRepository.save(new Product(title,coast));
    }

    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }
}
