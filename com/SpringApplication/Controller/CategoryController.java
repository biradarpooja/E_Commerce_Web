package com.SpringApplication.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringApplication.model.Category;
import com.SpringApplication.service.CategoryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/category")
public class CategoryController 
{
//private static final Category Category = null;
private final CategoryService categoryService;
public CategoryController(CategoryService categoryService) 
{
	this.categoryService=categoryService;
}

//add new category
@PostMapping("/add")
public ResponseEntity<Category> addCategory(@RequestBody Category category) 
{
    return ResponseEntity.ok(categoryService.addCategory(category));
}

//Get all categories
@GetMapping("/get")
public ResponseEntity<List<Category>> getAllCategories() {
    List<Category> categories = categoryService.getAllCategory();
    return ResponseEntity.ok(categories);
}

//get category by id
@GetMapping("/{id}")
public ResponseEntity<Category>getCategoryById(@PathVariable Long id)
{
	return categoryService.getCategoryById(id)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
}


//delete category
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteCategory(@PathVariable Long id)
{
	categoryService.deleteCATEGORY(id);
return ResponseEntity.ok("category deleted successfully");
}

}
