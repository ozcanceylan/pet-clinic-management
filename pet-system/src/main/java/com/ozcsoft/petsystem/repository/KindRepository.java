package com.ozcsoft.petsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozcsoft.petsystem.entity.Kind;

public interface KindRepository extends JpaRepository<Kind, Long>{
	Boolean existsByKindName(String kindName);
}
