package com.test.product;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "mock-service", url = "http://localhost:3001")
public interface ProductClient {

	@RequestMapping(method = RequestMethod.GET, value = "/product/{productId}/similarids")
    List<Integer> getProductSimilarids(@PathVariable("productId") String productId);

    @RequestMapping(method = RequestMethod.GET, value = "/product/{productId}", produces = "application/json")
    ProductDetailDTO getProductDetailById(@PathVariable("productId") String productId);
}
