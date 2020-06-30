package com.rahul.suppliers.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;*/
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.nineleaps.suppliers.model.Product;
import com.rahul.nineleaps.suppliers.model.Supplier;
import com.rahul.suppliers.Repository.SupplierRepository;
import com.rahul.suppliers.exceptions.ProductNotFoundException;
import com.rahul.suppliers.service.talk.to.ProductProxy;



@RestController
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	private SupplierRepository repository;
	@Autowired
	private ProductProxy proxy;
	/*
	 * @Autowired private ProductProxy proxy;
	 */
	/* @Autowired KafkaTemplate<String, Object> template; */
	private String topic = "nineleaps";

	@PostMapping(path = "/create")
	public void createSupplier(@Valid @RequestBody Supplier supplier) {
		int id = supplier.getId();
		Product product = proxy.checkProductAvailability(id);
		if (product == null) {
			throw new ProductNotFoundException("product not found");
		}
		repository.save(supplier);
	}

//paganation needs to be implemented here 
	/*
	 * @GetMapping(path = "/all") public @ResponseBody Page<Supplier> getAll() {
	 * return repository.findAll(Pageable); }
	 */

	@GetMapping(path = "/get/{id}")
	public Supplier getById(@PathVariable Integer id) throws Exception {
		Optional<Supplier> opt = repository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else
			throw new Exception("please provide correct supplier id ");
	}

	@GetMapping(path = "/all")
	public List<Supplier> getAll() {
		return repository.findAll();
	}
	/*
	 * Query query = Query.empty().pageRequest(CassandraPageRequest.first(10));
	 * Slice<User> slice = template.slice(query, User.class);
	 * 
	 * do {
	 * 
	 * //consume slice
	 * 
	 * if (slice.hasNext()) { slice = template.select(query, slice.nextPageable(),
	 * User.class); } else { break; } } while (!slice.getContent().isEmpty());
	 * 
	 * assertThat(ids).hasSize(100); assertThat(iterations).isEqualTo(10);
	 * 
	 * interface UserRepository implements Repository<User, String> {
	 * 
	 * Slice<User> findAllByName(String name, Pageable pageRequest); }
	 */

//throw exception if id is not present

	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) throws Exception {
		repository.deleteById(id);
	}

	@PutMapping(path = "/update/{id}")
	public void updateById(@PathVariable Integer id, @RequestBody Supplier supplier) throws Exception {

		Optional<Supplier> op = repository.findById(id);
		if (op.isPresent())
			repository.save(supplier);
		else
			throw new Exception("Supplier not found by id.");
	}

	// only kafka listener needs to be integrated
	/*
	 * @KafkaListener(topics = "nineleaps", groupId = "rahul", containerFactory =
	 * "supplierKafkaListenerFactory") public void getuser(Order order) throws
	 * Exception {
	 * 
	 * Set<Product> product =proxy.checkSupplierAgainstProduct(order.getItem());
	 * if(product == null | ((product==null))) throw new
	 * Exception("Supplier is not found againts  product"); else
	 * System.out.println("Send  mail to supplier.");
	 * 
	 * }
	 */

}
