package com.SpringApplication.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringApplication.model.Product;
import com.SpringApplication.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productservice;
	
	//create product
	@PostMapping("/add")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productservice.saveProduct(product));
    }
	//get all product
	@GetMapping("/get")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productservice.getAllProducts());
    }

//get product by id
@GetMapping("/{id}")
public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
    return ResponseEntity.ok(productservice.getProductById(id));
}
//Update product
@PutMapping("/{id}")
public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
    Product updatedProduct = productservice.updateProduct(id, product);
    if (updatedProduct != null) {
        return ResponseEntity.ok(updatedProduct);
    }
    return ResponseEntity.notFound().build();
}

// Delete product
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
    boolean deleted = productservice.deleteProduct(id);
    if (deleted) {
        return ResponseEntity.ok("Product deleted successfully");
    }
    return ResponseEntity.notFound().build();
}
}
