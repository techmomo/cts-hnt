package com.mohsinkd786.data.repos;

import com.mohsinkd786.data.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    Product findByProductId(String productId);
}
