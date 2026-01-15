package com.SpringApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringApplication.model.Category;
import com.SpringApplication.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Query by category id
    List<Product> findByCategory_Id(Long categoryId);

    // Query by category name
    List<Product> findByCategory_Name(String name);
}
