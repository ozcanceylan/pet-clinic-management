package com.ozcsoft.petsystem.service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ozcsoft.petsystem.entity.Animal;
import com.ozcsoft.petsystem.entity.Diagnosis;
import com.ozcsoft.petsystem.entity.Kind;
import com.ozcsoft.petsystem.exception.ResourceAlreadyExistsException;
import com.ozcsoft.petsystem.exception.ResourceNotFoundException;
import com.ozcsoft.petsystem.payload.dto.AnimalDto;
import com.ozcsoft.petsystem.payload.mapper.Mapper;
import com.ozcsoft.petsystem.repository.AnimalRepository;
import com.ozcsoft.petsystem.repository.DiagnosisRepository;
import com.ozcsoft.petsystem.repository.KindRepository;
import com.ozcsoft.petsystem.service.AnimalService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService{
	private final AnimalRepository animalRepository;
	private final KindRepository kindRepository;
	private final DiagnosisRepository diagnosisRepository;

	@Override
	public List<AnimalDto> getAllAnimals() {
		List<Animal> animals = animalRepository.findAll();
		List<AnimalDto> animalDtos = animals.stream().map(
					(animal) -> Mapper.mapToDto(animal) 
				).collect(Collectors.toList());
		return animalDtos;
	}

	@Override
	public AnimalDto findAnimalById(Long id) {
		Animal animal = animalRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Animal", "id", id));
		
		return Mapper.mapToDto(animal);
	}

	@Override
	public AnimalDto createAnimal(AnimalDto animalDto) {
		if (animalDto.getId() != null && animalRepository.existsById(animalDto.getId())) {
			throw new ResourceAlreadyExistsException("Animal", "animal id", Long.toString(animalDto.getId()));
		}
		Animal animal = Mapper.mapToEntity(animalDto);
		Animal newAnimal = animalRepository.save(animal);
		return Mapper.mapToDto(newAnimal);
	}

	@Override
	public void deleteById(Long id) {
		Animal animal = animalRepository.findById(id)
				.orElseThrow(
						() -> new ResourceNotFoundException("Animal", "id", id));
		animalRepository.delete(animal);
	}

	@Override
	public AnimalDto updateAnimal(Long animalId, AnimalDto animalDto) {
		Animal animal = animalRepository.findById(animalId)
				.orElseThrow(
						() -> new ResourceNotFoundException("Animal", "Id", animalId));
		Kind kind = kindRepository.findById(animalDto.getKindId())
				.orElseThrow(
						() -> new ResourceNotFoundException("Kind", "id", animalDto.getKindId()));
		List<Diagnosis> diagnosis = animalDto.getDiagnosis();
		
		diagnosis.stream().forEach(
				(diagnose) ->{ 
				if(!diagnosisRepository.existsById(diagnose.getId())) {
					throw new ResourceNotFoundException("Diagnosis", "id", diagnose.getId());
				}});
		animal.setName(animalDto.getName());
		animal.setAge(animalDto.getAge());
		animal.setWeight(animalDto.getWeight());
		animal.setHeight(animalDto.getHeight());
		animal.setKind(kind);
		animal.setDiagnosis(diagnosis);
		animalRepository.save(animal);
		return Mapper.mapToDto(animal);
	}
	
	
}
