package com.harsha.springdomainevents.persistence.repository;

import com.harsha.springdomainevents.persistence.models.TeacherProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherProjection, Long> {
    Optional<TeacherProjection> findByEmail(String email);

    Optional<TeacherProjection> findByTeacherId(String teacherId);
}
