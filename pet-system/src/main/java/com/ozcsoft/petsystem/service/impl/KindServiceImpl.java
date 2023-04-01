package com.ozcsoft.petsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ozcsoft.petsystem.entity.Kind;
import com.ozcsoft.petsystem.exception.ResourceAlreadyExistsException;
import com.ozcsoft.petsystem.exception.ResourceNotFoundException;
import com.ozcsoft.petsystem.payload.dto.KindDto;
import com.ozcsoft.petsystem.payload.mapper.Mapper;
import com.ozcsoft.petsystem.repository.KindRepository;
import com.ozcsoft.petsystem.service.KindService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KindServiceImpl implements KindService{
	private final KindRepository kindRepository;

	@Override
	public List<KindDto> getAllKinds() {
		List<Kind> kinds = kindRepository.findAll();
		List<KindDto> kindDtos = kinds.stream().map( (kind) -> Mapper.mapToDto(kind) ).collect(Collectors.toList());
		return kindDtos;
	}

	@Override
	public KindDto createKind(KindDto kindDto) {
		
		if(kindRepository.existsByKindName(kindDto.getKindName())) {
			throw new ResourceAlreadyExistsException("Kind", "Kind name", kindDto.getKindName());
		}
		if (kindDto.getId()!=null && kindRepository.existsById(kindDto.getId())) {
			throw new ResourceAlreadyExistsException("Kind", "kind id", Long.toString(kindDto.getId()));
		}
		//kindDto.setId(null);
		Kind kind = Mapper.mapToEntity(kindDto);
		Kind kindCreated = kindRepository.save(kind);
		return Mapper.mapToDto(kindCreated);
	}

	@Override
	public void deleteById(Long id) {
		Kind kind = kindRepository.findById(id)
				.orElseThrow(
						() -> new ResourceNotFoundException("Kind", "id", id));
		kindRepository.delete(kind);
	}

	@Override
	public KindDto updateKind(long kindId, KindDto kindDto) {
		Kind kind = kindRepository.findById(kindId)
				.orElseThrow(
						() -> new ResourceNotFoundException("kind", "id", kindId));
		if(kindRepository.existsByKindName(kindDto.getKindName())) {
			throw new ResourceAlreadyExistsException("Kind", "kind name", kindDto.getKindName());
		}
		kind.setKindName(kindDto.getKindName());
		Kind updatedKind = kindRepository.save(kind);
		return Mapper.mapToDto(updatedKind);
	}
	
	
}
