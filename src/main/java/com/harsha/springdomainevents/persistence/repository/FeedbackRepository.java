package com.harsha.springdomainevents.persistence.repository;

import com.harsha.springdomainevents.persistence.models.FeedbackProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackProjection, Long> {
}
