package com.ozcsoft.petsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ozcsoft.petsystem.entity.Diagnosis;
import com.ozcsoft.petsystem.exception.ResourceAlreadyExistsException;
import com.ozcsoft.petsystem.exception.ResourceNotFoundException;
import com.ozcsoft.petsystem.payload.dto.DiagnosisDto;
import com.ozcsoft.petsystem.payload.mapper.Mapper;
import com.ozcsoft.petsystem.repository.DiagnosisRepository;
import com.ozcsoft.petsystem.service.DiagnosisService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService{
	private final DiagnosisRepository diagnosisRepository;

	@Override
	public List<DiagnosisDto> getAllDiagnosis() {
		List<Diagnosis> diagnosis = diagnosisRepository.findAll();
		List<DiagnosisDto> diagnosisDto = 
				diagnosis.stream()
				.map( (diagnosis1) -> Mapper.mapToDto(diagnosis1)).collect(Collectors.toList());
		return diagnosisDto;
	}

	@Override
	public DiagnosisDto createDiagnosis(DiagnosisDto diagnosisDto) {
		if(diagnosisDto.getId() != null && diagnosisRepository.existsById(diagnosisDto.getId())) {
			throw new ResourceAlreadyExistsException("Diagnosis", "id", Long.toString(diagnosisDto.getId()));
		}
		if(diagnosisRepository.existsBydisease(diagnosisDto.getDisease())) {
			throw new ResourceAlreadyExistsException("Diagnosis", "disease", diagnosisDto.getDisease());
		}
		Diagnosis diagnosis = Mapper.mapToEntity(diagnosisDto);
		Diagnosis savedDiagnosis = diagnosisRepository.save(diagnosis);
		
		return Mapper.mapToDto(savedDiagnosis);
	}

	@Override
	public void deleteById(Long id) {
		Diagnosis diagnosis = diagnosisRepository.findById(id)
				.orElseThrow(
						() -> new ResourceNotFoundException("Diagnosis", "id", id));
		diagnosisRepository.delete(diagnosis);
	}

	@Override
	public DiagnosisDto updateDiagnosis(Long diagnosisId, DiagnosisDto diagnosisDto) {
		Diagnosis diagnosis = diagnosisRepository
				.findById(diagnosisId).orElseThrow(
						() -> new ResourceNotFoundException("Diagnosis", "id", diagnosisId));
		if(diagnosisRepository.existsBydisease(diagnosisDto.getDisease())) {
			throw new ResourceAlreadyExistsException("Diagnosis", "disease", diagnosisDto.getDisease());
		}
		
		diagnosis.setDisease(diagnosisDto.getDisease());
		Diagnosis updatedDiagnosis = diagnosisRepository.save(diagnosis);

		return Mapper.mapToDto(updatedDiagnosis);
	}
	
	
}
