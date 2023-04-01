package com.ozcsoft.petsystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozcsoft.petsystem.payload.dto.DiagnosisDto;
import com.ozcsoft.petsystem.service.DiagnosisService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/diagnosis")
@RequiredArgsConstructor
public class DiagnosisController {
	private final DiagnosisService diagnosisService;
	
	@GetMapping
	public ResponseEntity<List<DiagnosisDto>> getAlDiagnosis(){
		return ResponseEntity.ok(diagnosisService.getAllDiagnosis());
	}
	
	@PostMapping
	public ResponseEntity<DiagnosisDto> createNewDiagnosis(@Valid @RequestBody DiagnosisDto diagnosisDto){
		return new ResponseEntity<>(diagnosisService.createDiagnosis(diagnosisDto), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDiagnosisById(@PathVariable("id") Long id){
		diagnosisService.deleteById(id);
		return ResponseEntity.ok("Succesfully Deleted!");
	}
	@PutMapping("/{id}")
	public ResponseEntity<DiagnosisDto> updateDiagnosis(
						 @PathVariable("id") Long id,
						 @Valid @RequestBody DiagnosisDto diagnosisDto){
		return ResponseEntity.ok(diagnosisService.updateDiagnosis(id, diagnosisDto));
	}
}
