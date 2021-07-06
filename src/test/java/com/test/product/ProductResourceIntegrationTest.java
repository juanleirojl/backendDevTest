package com.test.product;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductResourceIntegrationTest {

	@LocalServerPort
	private int port;
	
	@Test
	void shouldReturnOkProductDetailWhenProductIdExist() {
		given()
			.basePath("product/{productId}/similar")
			.accept(ContentType.JSON)
			.pathParam("productId", 1)
			.port(port)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
		
	}
	
	@Test
	void shouldReturnNotFoundWhenProductDoesntExist() {
		given()
			.basePath("product/{productId}/similar")
			.accept(ContentType.JSON)
			.pathParam("productId", 7)
			.port(port)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
		
	}
	
	@Test
	void shouldReturnSocketTimeOutException() {
		given()
			.basePath("product/{productId}/similar")
			.accept(ContentType.JSON)
			.pathParam("productId", 3)
			.port(port)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
	}
}
