package com.geekbrains.springData.Service;

import com.geekbrains.springData.DTO.ProductDto;
import com.geekbrains.springData.Exceptions.ResourceNotFoundException;
import com.geekbrains.springData.Repository.ProductRepository;
import com.geekbrains.springData.Model.Product;
import com.geekbrains.springData.Repository.Specification.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Page<Product> findAll(Integer p, Integer maxScore, Integer minScore, String name){
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

    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

//    public void createNewProduct( String title, Integer coast){
//        productRepository.save(new Product(title,coast));
//    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    @Transactional
    public Product update(ProductDto productDto){
        Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Невозможно обновить продукт, в базе не найден, id: " + productDto.getId()));
        product.setCoast(productDto.getCoast());
        product.setTitle(productDto.getTitle());
        return product;
    }

    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }
}
