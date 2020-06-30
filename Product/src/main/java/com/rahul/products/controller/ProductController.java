package com.rahul.products.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.products.Repository.ProductRepository;
import com.rahul.products.exceptions.ProductNotFoundException;
import com.rahul.products.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository repository;

	@PostMapping(path = "/create")
	public void createProduct(@Valid @RequestBody Product product) {
		repository.save(product);
	}

	@GetMapping(path = "/get/{id}")
	public Product getById(@PathVariable int id) throws Exception {
		Product op = repository.findByPkProductid(id);
		if (op != null) {
			return op;
		} else {
			throw new ProductNotFoundException("product not found");
		}

	}

	@GetMapping(path = "/all")
	public List<Product> getAll() throws Exception {
		return repository.findAll();
	}

	@PutMapping(path = "/update")
	public void updtaeById(@RequestBody Product product) throws Exception {
		repository.save(product);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable int id) {
		Product product = repository.findByPkProductid(id);
		repository.delete(product);
	}

}
