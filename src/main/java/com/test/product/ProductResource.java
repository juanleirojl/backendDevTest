package com.test.product;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("product")
@AllArgsConstructor
public class ProductResource {
	
	private ProductClient productClient;

	@GetMapping("/{productId}/similar")
	public ResponseEntity<Set<ProductDetailDTO>> findSimilarProducts(@Valid @PathVariable String productId) {
		Set<ProductDetailDTO> listSimilarProducts = this.productClient.getProductSimilarids(productId)
																		.stream()
																		.map(product-> this.productClient.getProductDetailById(product.toString()))
																		.collect(Collectors.toSet());
		
		return ResponseEntity.ok(listSimilarProducts);
		
	}
	
}
