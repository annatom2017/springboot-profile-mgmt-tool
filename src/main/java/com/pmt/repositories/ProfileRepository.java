package com.pmt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pmt.entities.Profile;

/**
 * Repository for DB operations
 */

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {
	
}
