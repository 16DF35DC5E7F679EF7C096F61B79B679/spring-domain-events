package com.harsha.springdomainevents.persistence.repository;

import com.harsha.springdomainevents.persistence.models.ClassProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassProjection, Long> {
}
