package com.hobbyt.domain.post.controller;

import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hobbyt.domain.member.entity.Member;
import com.hobbyt.domain.post.service.PostLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/post/{post-id}/like")
@RequiredArgsConstructor
public class PostLikeController {
	private PostLikeService postLikeService;

	@PostMapping
	public ResponseEntity<Void> likePost(@AuthenticationPrincipal Member member,
		@Min(value = 0) @PathVariable(name = "post-id") Long postId) {

		return ResponseEntity.ok().build();
	}

	@DeleteMapping
	public ResponseEntity<Void> cancleLike(@AuthenticationPrincipal Member member,
		@Min(value = 0) @PathVariable(name = "post-id") Long postId) {

		return ResponseEntity.ok().build();
	}
}