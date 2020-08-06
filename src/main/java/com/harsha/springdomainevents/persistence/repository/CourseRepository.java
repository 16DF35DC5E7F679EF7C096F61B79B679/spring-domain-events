package com.harsha.springdomainevents.persistence.repository;

import com.harsha.springdomainevents.persistence.models.CourseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseProjection, Long> {
    Optional<CourseProjection> findByCourseCode(String courseCode);
    Optional<CourseProjection> findByCourseId(String courseId);
}
