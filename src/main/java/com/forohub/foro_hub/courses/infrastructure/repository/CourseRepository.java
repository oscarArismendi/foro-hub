package com.forohub.foro_hub.courses.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forohub.foro_hub.courses.domain.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
