package com.rahul.orders.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.rahul.orders.models.Order;
import com.rahul.orders.models.OrderTablePrimaryKey;

public interface OrderRepository extends CassandraRepository<Order, OrderTablePrimaryKey> {

}
