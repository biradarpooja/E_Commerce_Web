package com.SpringApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pid;
	private String name;
	//private String category;
	private double price;
	private String image;

    // Many products belong to one category
    @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "category_id") 
    @JoinColumn(name = "id") // Foreign Key in Product table
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;
	
	public Product() {}
	
	public Product(String name,Category category,double price,String image) {
		this.name=name;
		this.category=category;
		this.price=price;
		this.image=image;
	}
	
	
	//Getter and Setter
	public Long getId()
	{
		return pid;
	}
	public void setId(Long pid) 
	{
		this.pid=pid;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name=name;
	}
	public Category getCategory() 
{
		return category;	
	}
public void setCategory(Category category) 
	{
		this.category=category;
	}
	public Double getPrice() 
	{
		return price;
	}
	public void setPrice(Double price) 
	{
		this.price=price;
	}
	public String getImage()
	{
		return image;
	}
	public void setImage(String image) 
	{
		this.image=image;
	}

}
