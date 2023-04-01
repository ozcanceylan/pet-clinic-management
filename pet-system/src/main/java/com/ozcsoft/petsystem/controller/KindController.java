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

import com.ozcsoft.petsystem.payload.dto.KindDto;
import com.ozcsoft.petsystem.service.KindService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/kind")
@RequiredArgsConstructor
public class KindController {
	private final KindService kindService;
	
	@GetMapping
	public ResponseEntity<List<KindDto>> getAllKinds(){
		return ResponseEntity.ok(kindService.getAllKinds());
	}
	
	@PostMapping
	public ResponseEntity<KindDto> createNewKind(@Valid @RequestBody KindDto kindDto){
		return new ResponseEntity<>(kindService.createKind(kindDto), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteKindById(@PathVariable("id") Long id){
		kindService.deleteById(id);
		return ResponseEntity.ok("Succesfully Deleted!");
	}
	@PutMapping("/{id}")
	public ResponseEntity<KindDto> updateKind(
			@PathVariable("id") Long id, 
			@Valid @RequestBody KindDto kindDto){
		KindDto updatedKind = kindService.updateKind(id, kindDto);
		return ResponseEntity.ok(updatedKind);
	}
	
}
