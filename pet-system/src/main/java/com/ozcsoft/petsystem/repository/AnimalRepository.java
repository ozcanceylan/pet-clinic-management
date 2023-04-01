package com.ozcsoft.petsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozcsoft.petsystem.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
}
