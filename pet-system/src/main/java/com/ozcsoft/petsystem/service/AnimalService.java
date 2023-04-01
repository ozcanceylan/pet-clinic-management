package com.ozcsoft.petsystem.service;

import java.util.List;

import com.ozcsoft.petsystem.payload.dto.AnimalDto;

public interface AnimalService {
	List<AnimalDto> getAllAnimals();
	AnimalDto findAnimalById(Long id);
	AnimalDto createAnimal(AnimalDto AnimalDto);
	void deleteById(Long id);
	AnimalDto updateAnimal(Long animalId, AnimalDto animalDto);
}
