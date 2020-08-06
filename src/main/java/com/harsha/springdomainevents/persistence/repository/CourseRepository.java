package com.harsha.springdomainevents.persistence.repository;

import com.harsha.springdomainevents.persistence.models.CourseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseProjection, Long> {
}
