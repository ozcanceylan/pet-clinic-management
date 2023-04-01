package com.ozcsoft.petsystem.service;

import java.util.List;

import com.ozcsoft.petsystem.payload.dto.KindDto;

public interface KindService {
	List<KindDto> getAllKinds(); 
	KindDto createKind(KindDto kindDto);
	void deleteById(Long id);
	KindDto updateKind(long kindId, KindDto kindDto);
}
