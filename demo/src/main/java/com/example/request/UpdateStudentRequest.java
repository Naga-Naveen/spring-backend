package com.example.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentRequest {
	
	@NotNull(message="student id is required")
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;

}
