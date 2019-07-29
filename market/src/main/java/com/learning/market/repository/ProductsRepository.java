package com.learning.market.repository;

import com.learning.market.domain.Products;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ProductsRepository extends CrudRepository<Products, Long> {

    Products getById(Long id);
}
