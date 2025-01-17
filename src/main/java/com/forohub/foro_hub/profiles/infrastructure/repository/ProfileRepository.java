package com.forohub.foro_hub.profiles.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forohub.foro_hub.profiles.domain.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
