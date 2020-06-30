package com.rahul.orders.models;

import java.io.Serializable;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;



@PrimaryKeyClass
public class OrderTablePrimaryKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	@Column("id")
	private int id;

	@PrimaryKeyColumn(name = "customer_email", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	@Column("customer_email")
	private String customerEmail;
	
	

	public OrderTablePrimaryKey() {
		
	}

	public OrderTablePrimaryKey(int id, String customerEmail) {
		super();
		this.id = id;
		this.customerEmail = customerEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
}