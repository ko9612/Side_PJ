package com.hobbyt.domain.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hobbyt.domain.user.dto.request.EmailRequest;
import com.hobbyt.domain.user.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;

	@PostMapping("/code")
	public ResponseEntity mailConfirm(@Validated @RequestBody EmailRequest emailRequest) {
		String code = authService.sendAuthenticationCodeEmail(emailRequest);

		return new ResponseEntity(code, HttpStatus.CREATED);
	}
}
