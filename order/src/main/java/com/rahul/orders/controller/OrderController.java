package com.rahul.orders.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.orders.ExceptionHandler.OrderNotPlacedException;
import com.rahul.orders.Repository.OrderRepository;
import com.rahul.orders.models.Item;
import com.rahul.orders.models.Order;
import com.rahul.orders.models.Product;
import com.rahul.orders.service.talk.to.ProductProxy;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderRepository repository;
	@Autowired
	private ProductProxy proxy;
	@PostMapping(value="/create")
	public void CreateOrder(@Valid @RequestBody Order order) {
		
		List<Item> items = order.getItem();
		for(Item i:items) {
			Product product=proxy.checkProductAvailability(i.getProductId());
			if (product==null) {
				throw new OrderNotPlacedException("Product is out of stock");
			}
			else
				repository.save(order);
			
		}
		
	
	}
	@GetMapping("/all")
	public List<Order> getAll() throws Exception {
		return repository.findAll();
	}

}

