package com.ozcsoft.petsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozcsoft.petsystem.payload.dto.LoginDto;
import com.ozcsoft.petsystem.payload.dto.RegisterDto;
import com.ozcsoft.petsystem.payload.jwt.JWTAuthResponse;
import com.ozcsoft.petsystem.service.AuthService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;
	// login
	@PostMapping(value = {"/login", "/signin"})
	public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto longinDto){
		String token = authService.login(longinDto);
		
		JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
		jwtAuthResponse.setAccessToken(token);
		return ResponseEntity.ok(jwtAuthResponse);
		
	}
	
	// register
	@PostMapping(value = {"/register", "signup"})
	public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
		String response = authService.register(registerDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
