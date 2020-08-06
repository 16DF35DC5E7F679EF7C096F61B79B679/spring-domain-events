package com.harsha.springdomainevents.persistence.repository;

import com.harsha.springdomainevents.persistence.models.StudentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentProjection, Long> {
}
