package com.app.springrest.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.app.springrest.pojos.Udosedate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomRequest {
	
		LocalDate date;
	String slot;

}
