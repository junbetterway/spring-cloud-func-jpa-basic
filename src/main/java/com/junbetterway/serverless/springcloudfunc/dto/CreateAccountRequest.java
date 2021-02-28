package com.junbetterway.serverless.springcloudfunc.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest {

	private String name;
	private BigDecimal balance;
	
}
