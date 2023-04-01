package com.ozcsoft.petsystem.payload.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisDto {
	private Long id;
	@NotEmpty
	@Size(min = 2, message = "Disease must contain atleast 2 character.")
	private String disease;
}
