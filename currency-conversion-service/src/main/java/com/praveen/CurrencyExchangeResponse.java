package com.praveen;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchangeResponse {

	private Long id;

	private String from;

	private String to;

	private BigDecimal conversionMultiple;

	private String environment;
}
