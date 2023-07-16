package com.app.springrest.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {

	private String message;
	private LocalDate date;
	
	public ApiResponse(String message) {
		super();
		this.message = message;
	}
}
