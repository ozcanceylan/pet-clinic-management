package com.ozcsoft.petsystem.service;

import java.util.List;

import com.ozcsoft.petsystem.payload.dto.DiagnosisDto;

public interface DiagnosisService {
	List<DiagnosisDto> getAllDiagnosis();
	DiagnosisDto createDiagnosis(DiagnosisDto diagnosisDto);
	void deleteById(Long id);
	DiagnosisDto updateDiagnosis(Long diagnosisId, DiagnosisDto diagnosisDto);
}
