package com.hobbyt.domain.post.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hobbyt.domain.tag.entity.Tag;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostTag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "post_id")
	private Post post;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "tag_id")
	private Tag tag;

	public static PostTag of(Post post, Tag tag) {
		return new PostTag(post, tag);
	}

	private PostTag(Post post, Tag tag) {
		this.post = post;
		this.tag = tag;
	}
}
