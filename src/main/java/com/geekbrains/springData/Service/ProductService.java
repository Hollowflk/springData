package com.geekbrains.springData.Service;

import com.geekbrains.springData.DTO.ProductDto;
import com.geekbrains.springData.Repository.ProductRepository;
import com.geekbrains.springData.Model.Product;
import com.geekbrains.springData.Repository.Specification.ProductSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Page<Product> find(Integer p, Integer maxScore, Integer minScore, String name){
        Specification<Product> specification = Specification.where(null);

        if(minScore != null){
            specification = specification.and(ProductSpecification.scoreGreaterOrElseThan(minScore));
        }
        if(maxScore != null){
            specification = specification.and(ProductSpecification.lessThanOrEqualTo(maxScore));
        }
        if(name != null){
            specification = specification.and(ProductSpecification.nameLike(name));
        }

        return productRepository.findAll(specification, PageRequest.of(p -1, 5));
    }

    public ProductDto findById(Integer id){
        return  productRepository.findById(id).map(s -> new ProductDto(s)).orElseThrow();
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
