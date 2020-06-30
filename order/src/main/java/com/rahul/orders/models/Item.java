package com.rahul.orders.models;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.Column;


@org.springframework.data.cassandra.core.mapping.UserDefinedType("item_entity")
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column("product_id")
	private int productId;
	@Column("quantity")
	private int quantity;
	@Column("price")
	private double price;
	
	public Item() {
		
	}

	public Item(int productId, int quantity, double price) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
