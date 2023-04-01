package com.ozcsoft.petsystem.service;

import com.ozcsoft.petsystem.payload.dto.LoginDto;
import com.ozcsoft.petsystem.payload.dto.RegisterDto;

public interface AuthService {
	String login(LoginDto loginDto);
	String register(RegisterDto dto);
}
