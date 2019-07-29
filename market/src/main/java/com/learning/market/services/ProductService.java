package com.learning.market.services;

import com.learning.market.domain.Products;
import com.learning.market.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    public Products saveOrUpdate(Products products) {
        if(products.getStatus() == null || products.getStatus() == "") {
            products.setStatus("TO_DO");
        }

        return productsRepository.save(products);
    }

    public Iterable<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public Products findById(Long id) {

        return productsRepository.getById(id);
    }

    public void deleteProductsById(Long id) {
        productsRepository.deleteById(id);
    }
}
