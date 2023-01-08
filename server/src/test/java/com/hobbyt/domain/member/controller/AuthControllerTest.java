package com.hobbyt.domain.member.controller;

import static com.hobbyt.global.security.constants.AuthConstants.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hobbyt.domain.config.TestMemberDetailService;
import com.hobbyt.domain.member.dto.request.EmailRequest;
import com.hobbyt.domain.member.entity.Authority;
import com.hobbyt.domain.member.service.AuthService;
import com.hobbyt.domain.member.service.AuthenticationCode;
import com.hobbyt.global.security.jwt.JwtTokenProvider;

@SpringBootTest(classes = TestMemberDetailService.class)
@AutoConfigureMockMvc
class AuthControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private AuthService authService;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@DisplayName("메일 인증 api")
	@Test
	void mail_confirm() throws Exception {
		//given
		String code = AuthenticationCode.createCode().getCode();
		EmailRequest emailRequest = new EmailRequest("test@gmail.com");
		given(authService.sendAuthenticationCodeEmail(emailRequest)).willReturn(code);

		//when
		ResultActions actions = mockMvc.perform(
			post("/api/auth/code")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(emailRequest))
		);

		//then
		actions.andExpect(status().isCreated())
			.andDo(print());
	}

	@DisplayName("토큰 재발급 api")
	@Test
	void reissue() throws Exception {
		//given
		String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdXRob3JpdHkiOiJST0xFX1VTRVIiLCJlbWFpbCI6InBqNTAxNkBuYXZlci5jb20iLCJzdWIiOiJwajUwMTZAbmF2ZXIuY29tIiwiaWF0IjoxNjczMDc5OTAyLCJleHAiOjE2NzMyNjE3MDJ9.2tlaHBrLJBPijNNDdUxvo77Ec2XuOQNrRNotxTUOnIQ";
		String refreshToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwajUwMTZAbmF2ZXIuY29tIiwiaWF0IjoxNjczMDc5OTAyLCJleHAiOjYyMTUzNjg0NzAyfQ.NtCbbucwL4HXotVH3ZxPuirBphSmtKeS4BEgfcGkYoQ";
		String reissuedAccessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdXRob3JpdHkiOiJST0xFX1VTRVIiLCJlbWFpbCI6InBqNTAxNkBuYXZlci5jb20iLCJzdWIiOiJwajUwMTZAbmF2ZXIuY29tIiwiaWF0IjasfdasDc5OTAyLCJleHAiOjE2NzMyNjE3MDJ9.2tlaHBrLJBPijNNDdUxvo77Ec2XuOQNrRNotxTUOnIQ";
		String reissuedRefreshToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwajUwMTZAbmF2ZXIuY29tIiwiaWF0IjoxNjczMDc5OTAyLCJleHAiOjYyMTUzNjg0NzAyfQ.NtCbbucwL4HXotVH3ZxPuirBasdfeS4BEgfcGkYoQ";

		given(authService.reissueAccessToken(anyString(), anyString())).willReturn(reissuedAccessToken);
		given(authService.reissueRefreshToken(anyString())).willReturn(reissuedRefreshToken);
		//when
		ResultActions actions = mockMvc.perform(
			post("/api/auth/reissue")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.header(AUTH_HEADER, TOKEN_TYPE + " " + accessToken)
				.header(REFRESH_TOKEN_HEADER, refreshToken)
		);

		//then
		actions.andExpect(status().isOk())
			.andDo(print());
	}

	@DisplayName("로그아웃 api")
	@WithMockUser(username = "user1@gmail.com", password = "user1Pass")
	@Test
	void logout() throws Exception {
		// String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdXRob3JpdHkiOiJST0xFX1VTRVIiLCJlbWFpbCI6InBqNTAxNkBuYXZlci5jb20iLCJzdWIiOiJwajUwMTZAbmF2ZXIuY29tIiwiaWF0IjoxNjczMDc5OTAyLCJleHAiOjE2NzMyNjE3MDJ9.2tlaHBrLJBPijNNDdUxvo77Ec2XuOQNrRNotxTUOnIQ";
		// String refreshToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwajUwMTZAbmF2ZXIuY29tIiwiaWF0IjoxNjczMDc5OTAyLCJleHAiOjYyMTUzNjg0NzAyfQ.NtCbbucwL4HXotVH3ZxPuirBphSmtKeS4BEgfcGkYoQ";
		String accessToken = jwtTokenProvider.createAccessToken("test@gmail.com", Authority.ROLE_USER);
		String refreshToken = jwtTokenProvider.createRefreshToken("test@gmail.com");

		// willDoNothing().given(authService).logout(anyString(), anyString());

		ResultActions actions = mockMvc.perform(
			post("/api/auth/logout")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.header(AUTH_HEADER, TOKEN_TYPE + " " + accessToken)
				.header(REFRESH_TOKEN_HEADER, refreshToken)
		);

		actions.andExpect(status().isOk())
			.andDo(print());
	}
}