package com.rahul.products.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.rahul.products.model.Product;
import com.rahul.products.model.ProductPrimaryKey;

public interface ProductRepository extends CassandraRepository<Product, ProductPrimaryKey> {
	@Query(allowFiltering = true)
	Product findByPkProductid(int id);
}
