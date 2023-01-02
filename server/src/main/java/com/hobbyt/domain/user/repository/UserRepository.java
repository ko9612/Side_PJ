package com.hobbyt.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hobbyt.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
