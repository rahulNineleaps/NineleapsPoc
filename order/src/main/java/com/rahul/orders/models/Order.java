package com.rahul.orders.models;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("order_items")
public class Order implements Serializable{
		private static final long serialVersionUID = 1L;
		@PrimaryKey
		private Integer id;
		@Column("date")
		private String date;
		@Column("customer_name")
		private String customerName;
		@Column("customer_email")
		private String customerEmail;
		@Column("customer_address")
		private String customerAddress;
		@CassandraType(type = com.datastax.driver.core.DataType.Name.UDT, userTypeName = "item_entity")
		@Column("item_entity")
		private List<Item> item;
		@Column("total")
		private double total;
		
		public Order() {
			
		}
		
		public Order(Integer id, String date, String customerName, String customerEmail, String customerAddress,
				List<Item> item, double total) {
			super();
			this.id = id;
			this.date = date;
			this.customerName = customerName;
			this.customerEmail = customerEmail;
			this.customerAddress = customerAddress;
			this.item = item;
			this.total = total;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getCustomerEmail() {
			return customerEmail;
		}
		public void setCustomerEmail(String customerEmail) {
			this.customerEmail = customerEmail;
		}
		public String getCustomerAddress() {
			return customerAddress;
		}
		public void setCustomerAddress(String customerAddress) {
			this.customerAddress = customerAddress;
		}
		public List<Item> getItem() {
			return item;
		}
		public void setItem(List<Item> item) {
			this.item = item;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
		
		
					    
}
