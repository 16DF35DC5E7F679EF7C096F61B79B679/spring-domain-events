package com.harsha.springdomainevents.persistence.repository;

import com.harsha.springdomainevents.persistence.models.AddressProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressProjection, Long> {
}
