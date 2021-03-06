package com.rahul.products.serviceTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.cassandraunit.spring.CassandraUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahul.products.Repository.ProductRepository;
import com.rahul.products.controller.ProductController;
import com.rahul.products.model.Product;
import com.rahul.products.model.ProductPrimaryKey;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest({ "spring.data.cassandra.port=9042", "spring.data.cassandra.keyspace-name=test101" })
@EnableAutoConfiguration
@ComponentScan
@ContextConfiguration
@CassandraUnit



public class ProductControllerTest {
	// mockmvc is used to do controller test it introduces dispatcher servelet
	private MockMvc mockMvc;
	//@Autowired
	@Mock
	private ProductRepository productRepository;
	@Autowired
	private ProductController productController;
	@Before
	public void init() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void getProductTest() throws Exception {
		ProductPrimaryKey ppk = new ProductPrimaryKey(3, 2);
		Product product = new Product(ppk, "home2", 1000000000.0, "it is a home");

		when(productRepository.findByPkProductid(2)).thenReturn(product);

		mockMvc.perform(get("/product/get/{id}", 2)).andExpect(status().is(200)).andReturn().equals(product);

	}
	
	
	
	
	@Test
	public void deleteByIdTest()throws Exception{
		String uri = "product/delete/{id}";
		
		ProductPrimaryKey ppk = new ProductPrimaryKey(3, 2);
		Product product = new Product(ppk, "home2", 1000000000.0, "it is a home");

		when(productRepository.findByPkProductid(2)).thenReturn(product);
		mockMvc.perform(delete(uri, 2)).andExpect(status().is(200));
	}
	@Test
	public void createProductTest() throws Exception {
		String uri = "/product/create";
		ProductPrimaryKey ppk = new ProductPrimaryKey(3, 2);
		Product product = new Product(ppk, "home2", 1000000000.0, "it is a home");
		when(productRepository.save(product));
		mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).content(asJsonString(product)))
		.andExpect(status().is(200));

	}
	
	
		private static String asJsonString(final Object obj) {
			try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }}
	@Test
	public void updateProductTest()throws Exception{
		String uri="/product/update";
		ProductPrimaryKey ppk = new ProductPrimaryKey(3, 2);
		Product product = new Product(ppk, "home3", 1000000000.0, "it is a home");
		when(productRepository.save(product));
		mockMvc.perform(put(uri).contentType(MediaType.APPLICATION_JSON).content(asJsonString(product))).andExpect(status().is(200));
	}

	@Test
	public void getAllTest()throws Exception{
		String uri = "/product/all";
		mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}


}
