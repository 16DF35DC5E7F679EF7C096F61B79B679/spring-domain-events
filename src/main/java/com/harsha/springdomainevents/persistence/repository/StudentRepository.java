package com.harsha.springdomainevents.persistence.repository;

import com.harsha.springdomainevents.persistence.models.StudentProjection;
import com.harsha.springdomainevents.persistence.models.TeacherProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentProjection, Long> {
    Optional<StudentProjection> findByEmail(String email);
    Optional<StudentProjection> findByStudentId(String email);
}
