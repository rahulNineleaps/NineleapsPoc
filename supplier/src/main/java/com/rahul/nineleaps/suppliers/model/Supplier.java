package com.rahul.nineleaps.suppliers.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("supplier")

public class Supplier {
	public Supplier(@NotNull(message = "Supplier id can not be null") int id, @Size(min = 3, max = 50) String name,
			@Email String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Supplier() {

	}

	@PrimaryKey
	@NotNull(message = "Supplier id can not be null")
	private int id;
	@Size(min = 3, max = 50)
	private String name;
	@Email
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}