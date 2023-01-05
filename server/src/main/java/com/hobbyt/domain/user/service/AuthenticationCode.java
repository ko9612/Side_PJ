package com.hobbyt.domain.user.service;

import java.util.Random;

import lombok.Getter;

@Getter
public class AuthenticationCode {
	private static final int CODE_COUNT = 8;
	private static final int NUMBER_OF_CASES = 3;
	private static final int LOWER_CASE = 0;
	private static final int UPPER_CASE = 1;
	private static final int NUMBER = 2;

	private final String code;

	private AuthenticationCode(String code) {
		this.code = code;
	}

	public static AuthenticationCode createCode() {
		StringBuffer code = new StringBuffer();
		assemble(code);
		// 인증코드 검증 로직 필요?
		return new AuthenticationCode(code.toString());
	}

	private static void assemble(final StringBuffer code) {
		Random random = new Random();
		int index = 0;
		while (index++ < CODE_COUNT) {
			addNextCode(code, random);
		}
	}

	private static void addNextCode(final StringBuffer code, final Random random) {
		switch (random.nextInt(NUMBER_OF_CASES)) {
			case LOWER_CASE:    // a~z (ex. 1+97=98 => (char)98 = 'b')
				code.append((char)((random.nextInt(26)) + 97));
				break;
			case UPPER_CASE:    // A ~ Z
				code.append((char)((random.nextInt(26)) + 65));
				break;
			case NUMBER:    // 0 ~ 9
				code.append(random.nextInt(10));
				break;
		}
	}
}
