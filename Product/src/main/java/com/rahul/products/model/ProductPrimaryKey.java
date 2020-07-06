package com.rahul.products.model;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;


@PrimaryKeyClass
public class ProductPrimaryKey implements Serializable{

	public ProductPrimaryKey(int supplierId, int productid) {
		/* super(); */
		this.supplierId = supplierId;
		this.productid = productid;
	}

	/*
	 * public ProductPrimaryKey() {
	 * 
	 * }
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 @PrimaryKeyColumn(name = "supplierid", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	 private int supplierId; 
	 @PrimaryKeyColumn(name = "productid", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
	  private int productid;

		/*
		 * public ProductPrimaryKey() { super(); // TODO Auto-generated constructor stub
		 * }
		 */
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
	
}

