package com.harsha.springdomainevents.persistence.repository;

import com.harsha.springdomainevents.persistence.models.SubmissionProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends JpaRepository<SubmissionProjection, Long> {
}
