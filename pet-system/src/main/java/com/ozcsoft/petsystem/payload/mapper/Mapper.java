package com.ozcsoft.petsystem.payload.mapper;

import org.modelmapper.ModelMapper;

import com.ozcsoft.petsystem.entity.Animal;
import com.ozcsoft.petsystem.entity.Diagnosis;
import com.ozcsoft.petsystem.entity.Kind;
import com.ozcsoft.petsystem.payload.dto.AnimalDto;
import com.ozcsoft.petsystem.payload.dto.DiagnosisDto;
import com.ozcsoft.petsystem.payload.dto.KindDto;

public class Mapper {
	private static ModelMapper mapper = new ModelMapper();
	
	// 				Animal 
	public static AnimalDto mapToDto(Animal animal) {
		return mapper.map(animal, AnimalDto.class);
	}
	public static Animal mapToEntity(AnimalDto animalDto) {
		return mapper.map(animalDto, Animal.class);
	}
	
	//				Kind 
	public static KindDto mapToDto(Kind kind) {
	return mapper.map(kind, KindDto.class);
	}
	public static Kind mapToEntity(KindDto kindDto) {
	return mapper.map(kindDto, Kind.class);
	}
	
	//				Diagnosis
	public static DiagnosisDto mapToDto(Diagnosis diagnosis) {
	return mapper.map(diagnosis, DiagnosisDto.class);
	}
	public static Diagnosis mapToEntity(DiagnosisDto diagnosisDto) {
	return mapper.map(diagnosisDto, Diagnosis.class);
	}
}
