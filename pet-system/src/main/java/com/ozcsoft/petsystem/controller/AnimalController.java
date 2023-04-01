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

import com.ozcsoft.petsystem.payload.dto.AnimalDto;
import com.ozcsoft.petsystem.service.AnimalService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/animal")
public class AnimalController {
	private final AnimalService animalService;
	
	@GetMapping
	public ResponseEntity<List<AnimalDto>> retrieveAllAnimals(){
		return ResponseEntity.ok(animalService.getAllAnimals());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnimalDto> getAnimalById(@PathVariable("id") Long animalId){
		return ResponseEntity.ok(animalService.findAnimalById(animalId));
	}
	@PostMapping
	public ResponseEntity<AnimalDto> createAnimal(@Valid @RequestBody AnimalDto animalDto){
		return new ResponseEntity<>(animalService.createAnimal(animalDto), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAnimalById(@PathVariable("id") Long id){
		animalService.deleteById(id);
		return ResponseEntity.ok("Succesfully Deleted!");
	}
	@PutMapping("/{id}")
	public ResponseEntity<AnimalDto> updateAnimal(
						  @PathVariable("id") Long animalId,
						  @Valid @RequestBody AnimalDto animalDto){
		return ResponseEntity.ok(animalService.updateAnimal(animalId, animalDto));
	}
}
