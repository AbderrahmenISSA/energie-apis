package fr.energie.billing.controller;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestError {

	private String error;
	private String message;
}
