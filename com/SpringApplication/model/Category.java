package com.SpringApplication.model;



import java.util.List;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//private String naem;
	@Column(nullable = false, unique = true)
    private String name;
	//private String name;
	//public Category() {}
	 @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Product> products;
	 
	  // Constructors
	    public Category() {}
	public Category(String name) 
	{
        this.name = name;
    }
	 // Getters & Setters
    public Long getId() 
    {
        return id;
    }
	public void setId()
	{
		this.id=id;
	}
	public String getName() 
	{
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
	public static Optional<java.util.Locale.Category> findById(Long id2) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
