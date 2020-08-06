package com.harsha.springdomainevents.persistence.repository;

import com.harsha.springdomainevents.persistence.models.GradeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<GradeProjection, Long> {
}
