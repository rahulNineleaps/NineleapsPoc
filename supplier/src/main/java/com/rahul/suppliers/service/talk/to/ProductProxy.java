package com.rahul.suppliers.service.talk.to;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rahul.nineleaps.suppliers.model.Product;



@FeignClient(name="nineleaps-gateway") 
@RibbonClient(name="product")
public interface ProductProxy {
	
	@GetMapping("/product/product/get/{id}")
	public Product checkProductAvailability( @PathVariable("id") int id);

}
