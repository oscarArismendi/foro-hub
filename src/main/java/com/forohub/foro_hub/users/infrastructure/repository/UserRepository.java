package com.forohub.foro_hub.users.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forohub.foro_hub.users.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
