package com.test.product;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailDTO {

	@NotBlank
	@Min(1)
	private String 	   id;
	
	@NotBlank
	@Min(1)
	private String 	   name;
	
	@NotBlank
	private BigDecimal price;
	
	@NotBlank
	private boolean    availability;
	
}
