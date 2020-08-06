package com.harsha.springdomainevents.persistence.repository;

import com.harsha.springdomainevents.persistence.models.ClassLocationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassLocationRepository extends JpaRepository<ClassLocationProjection, Long> {
}
