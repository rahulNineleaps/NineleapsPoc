package com.rahul.products.model;



import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("product")
public class Product {
	
	@PrimaryKey
	private ProductPrimaryKey pk; 
	//@Size(min = 3, max = 50)
	@Column("name")
	private String name;
	//@PositiveOrZero
	@Column("price")
	private Double price ;
	//@Size(min = 10, max = 200)
	@Column("description")
	private String description;

	
	public Product(ProductPrimaryKey pk,
			/* @Size(min = 3, max = 50) */ String name,
			/* @PositiveOrZero */Double price,
			/* @Size(min = 10, max = 200) */ String description) {
		/* super(); */
		this.pk = pk;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	/*
	 * public Product() {
	 * 
	 * }
	 */
	public ProductPrimaryKey getPk() { return pk; } public void
	  setPk(ProductPrimaryKey pk) { this.pk = pk; }
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*
	 * public Product() { super(); // TODO Auto-generated constructor stub }
	 */
	
	
	
	

}
