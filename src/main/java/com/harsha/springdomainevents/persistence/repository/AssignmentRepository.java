package com.harsha.springdomainevents.persistence.repository;

import com.harsha.springdomainevents.persistence.models.AssignmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentProjection, Long> {
}
