package com.geekbrains.springData.Repository.Specification;

import com.geekbrains.springData.Model.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> scoreGreaterOrElseThan(Integer coast){
        return (((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("coast"), coast)));
    }

    public static Specification<Product> lessThanOrEqualTo(Integer coast){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("coast"), coast));
    }

    public static Specification<Product> nameLike(String title){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", title)));
    }
}
