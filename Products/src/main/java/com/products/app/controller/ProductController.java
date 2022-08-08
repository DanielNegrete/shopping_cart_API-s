package com.products.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.products.app.dto.ProductRequestDTO;
import com.products.app.dto.ResponseDTO;
import com.products.app.entity.Product;
import com.products.app.repository.ProductRepository;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path="/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping(path="/add")
	public ResponseEntity<ResponseDTO> addProduct(@RequestBody ProductRequestDTO productRequestDTO){
		Product product = new Product();
		product.setProductName(productRequestDTO.getProductName());
		product.setProductImage(productRequestDTO.getProductImage());
		product.setProductCategorie(productRequestDTO.getProductCategorie());
		product.setProductPrice(productRequestDTO.getProductPrice());
		productRepository.save(product);
		ResponseDTO responseDTO = new ResponseDTO("Product added", 200);
		
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@PostMapping(path="/update/{productId}")
	public ResponseEntity<ResponseDTO> updateProduct(@PathVariable Integer productId, @RequestBody ProductRequestDTO productRequestDTO){
		Optional<Product> product = productRepository.findById(productId);
		ResponseDTO responseDTO = new ResponseDTO("", 0);
		Product productU = product.get();
		
		if(product.isPresent()) {
			productU.setProductId(productId);
			productU.setProductName(productRequestDTO.getProductName());
			productU.setProductCategorie(productRequestDTO.getProductCategorie());
			productU.setProductPrice(productRequestDTO.getProductPrice());
			productRepository.save(productU);
			responseDTO.setMessage("Product updated");
			responseDTO.setStatusCode(200);
		}else {
			responseDTO.setMessage("Product not found");
			responseDTO.setStatusCode(404);
		}
		
	  	return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path="/delete/{productId}")
	public ResponseEntity<ResponseDTO> deleteProduct(@PathVariable Integer productId){
		productRepository.deleteById(productId);
		ResponseDTO responseDTO = new ResponseDTO("Product deleted", 200);
		
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.ACCEPTED);
	}
}
