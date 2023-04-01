package com.ozcsoft.petsystem.payload.dto;

import java.util.List;

import com.ozcsoft.petsystem.entity.Diagnosis;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDto {
	private Long id;
	@NotEmpty
	@Size(min = 2, message = "Name must contain atleast 2 characters.")
	private String name;
	
	private int age;
	
	private float weight;
	
	private float height;
	
	@NotNull
	private Long kindId;
	
	private List<Diagnosis> diagnosis;
}
