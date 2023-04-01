package com.ozcsoft.petsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozcsoft.petsystem.entity.Diagnosis;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long>{
	Boolean existsBydisease(String disease);
}
