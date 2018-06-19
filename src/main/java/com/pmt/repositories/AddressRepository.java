package com.pmt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pmt.entities.Address;

/**
 * Repository for DB operations
 */

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
	
}
