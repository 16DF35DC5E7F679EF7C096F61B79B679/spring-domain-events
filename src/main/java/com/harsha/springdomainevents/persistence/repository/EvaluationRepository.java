package com.harsha.springdomainevents.persistence.repository;

import com.harsha.springdomainevents.persistence.models.EvaluationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<EvaluationProjection, Long> {
}
