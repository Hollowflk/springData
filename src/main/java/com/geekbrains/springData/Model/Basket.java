package com.geekbrains.springData.Model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope()
public class Basket {

    private List<Product> basket;

    @PostConstruct
    public void init(){
        this.basket = new ArrayList<>();
    }
}
