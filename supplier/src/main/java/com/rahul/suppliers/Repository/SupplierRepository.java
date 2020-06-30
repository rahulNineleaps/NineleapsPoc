package com.rahul.suppliers.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.rahul.nineleaps.suppliers.model.Supplier;
@Repository
public interface SupplierRepository extends CassandraRepository<Supplier, Integer> {
	
}


