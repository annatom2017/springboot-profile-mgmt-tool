package com.pmt.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.pmt.entities.Profile;

/**
 * 
 * Service layer methods
 *
 */
@Validated
public interface ProfileService {

	List<Profile> listAllUsers();

	Profile getUserById(Integer profileId);

	Profile createUpdateUser(@Valid Profile user);

	void deleteUser(@Valid Profile user);

}
