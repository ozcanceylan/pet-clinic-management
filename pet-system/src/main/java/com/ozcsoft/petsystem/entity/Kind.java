package com.ozcsoft.petsystem.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "kinds")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Kind {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "animal_kind", nullable = false, unique=true)
	private String kindName;
	
	@OneToMany(mappedBy = "kind")
	private List<Animal> animals;
}
