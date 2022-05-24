package com.geekbrains.springData.Service;

import com.geekbrains.springData.DAO.ProductDAO;
import com.geekbrains.springData.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public Product getById(Integer id){
        return productDAO.findById(id).orElseThrow();
    }

    public List<Product> getAllProduct(){
        return productDAO.findAll();
    }

    public void createNewProduct(String title, Integer coast){
        productDAO.save(new Product(title,coast));
    }

    public void deleteById(Integer id){
        productDAO.deleteById(id);
    }
}
