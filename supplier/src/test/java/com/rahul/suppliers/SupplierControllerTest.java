package com.rahul.suppliers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.cassandraunit.spring.CassandraUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rahul.nineleaps.suppliers.model.Supplier;

import com.rahul.suppliers.Repository.SupplierRepository;
import com.rahul.suppliers.controller.SupplierController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest({ "spring.data.cassandra.port=9042", "spring.data.cassandra.keyspace-name=test101" })
@EnableAutoConfiguration
@ComponentScan
@ContextConfiguration
@CassandraUnit
public class SupplierControllerTest {
   private MockMvc mockMvc;
	@Mock
	private SupplierRepository supplierRepository;
	@Autowired
	private SupplierController supplierController;
	@Before
	public void init() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(supplierController).build();
	}
	
	
	@Test
	public void getSupplierTest() throws Exception {
		//1 | xyz@gmail.com | home
		Supplier supplier= new Supplier(1,"home","xyz@gmail.com");
		Optional<Supplier>opt2;
		Optional<Supplier> opt = null;
		when(supplierRepository.findById(2)).thenReturn(opt);
		mockMvc.perform(get("/supplier/get/{id}", 2)).andExpect(status().is(200)).andReturn().equals(opt);

	}
	
	@Test
	public void getAllSupplierTest()throws Exception{
		List<Supplier> opt = null;
		when(supplierRepository.findAll()).thenReturn(opt);	
		mockMvc.perform(get("/supplier/all")).andExpect(status().is(200)).andReturn().equals(opt);
		}
	
}
