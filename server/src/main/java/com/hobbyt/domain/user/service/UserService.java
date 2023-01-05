package com.hobbyt.domain.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hobbyt.domain.user.dto.request.SignupRequest;
import com.hobbyt.domain.user.entity.User;
import com.hobbyt.domain.user.repository.UserRepository;
import com.hobbyt.global.error.exception.UserExistException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Transactional
	public Long createUser(SignupRequest signupRequest) {
		checkUserExist(signupRequest.getEmail());
		String profileImage = "S3 default image";    // S3의 기본 프로필 이미지
		User user = signupRequest.toEntity(passwordEncoder, profileImage);

		return userRepository.save(user).getId();
	}

	private void checkUserExist(String email) {
		if (userRepository.existsByEmail(email)) {
			throw new UserExistException();
		}
	}
}