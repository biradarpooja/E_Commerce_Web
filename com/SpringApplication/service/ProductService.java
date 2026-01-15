package com.SpringApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringApplication.model.Product;
import com.SpringApplication.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	
	
	
	//save product
	public Product saveProduct(Product product) 
	{
		return productRepository.save(product);
	}
	
	//get all product
	public List<Product> getAllProducts()
	{
        return productRepository.findAll();
    }
    //get product by id
	 public Optional<Product> getProductById(Long id) {
	        return productRepository.findById(id);
	    }
	// Update product
	    public Product updateProduct(Long id, Product productDetails) {
	        return productRepository.findById(id).map(product -> {
	            product.setName(productDetails.getName());
	            product.setCategory(productDetails.getCategory());
	            product.setPrice(productDetails.getPrice());
	            product.setImage(productDetails.getImage());
	            return productRepository.save(product);
	        }).orElse(null);
	    }
	    
	 // Delete product
	    public boolean deleteProduct(Long id) {
	        return productRepository.findById(id).map(product -> {
	            productRepository.delete(product);
	            return true;
	        }).orElse(false);
	    }

}
