package com.hobbyt.notification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hobbyt.global.entity.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Notification extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, updatable = false, name = "sender_nickname")
	private String sender;
	@Column(nullable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	private NotificationType type;
	@Column(nullable = false, updatable = false, name = "article_title")
	private String title;
	@Column(nullable = false)
	private boolean checked = false;
}
