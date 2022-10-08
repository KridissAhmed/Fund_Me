package tn.esprit.fundme.controller;

import java.util.List;

import javax.batch.operations.JobExecutionAlreadyCompleteException;
import javax.batch.operations.JobRestartException;
import javax.ws.rs.POST;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.fundme.batch.BatchLauncher;
import tn.esprit.fundme.entities.Product;
import tn.esprit.fundme.services.ProductsService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class ProductsController {
	@Autowired
	ProductsService ProductsService ;
	
	@Autowired
    private BatchLauncher batchLauncher;

    @PostMapping("/batch")
    public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyCompleteException, JobRestartException, JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, org.springframework.batch.core.repository.JobRestartException {
         return batchLauncher.run();
    }
	@GetMapping("select")
	@ResponseBody
	public List<Product> getGuarantor(){
		List<Product>listProduct =ProductsService.retrieveAllProduct();
		return listProduct;
	}
	
	
	@GetMapping("/select/{operateur-id}")
	@ResponseBody
	public Product retrieveProduct(@PathVariable("operateur-id") Long ProductId) {
	return ProductsService.retrieveProduct(ProductId);
	}

	
	@PostMapping("/add")
	@ResponseBody
	public Product Product(@RequestBody Product G)
	{
			return ProductsService.addProduct(G);

	}
	
	@DeleteMapping("/delete/{operateur-id}")
	@ResponseBody
	public void removeProduct(@PathVariable("operateur-id") Long ProductId) {
		ProductsService.delete(ProductId);
	}

	@PutMapping("/modifyProduct")
	@ResponseBody
	public Product modifyProduct(@RequestBody Product Product) {
	return ProductsService.updateProduct(Product);
	}
}
