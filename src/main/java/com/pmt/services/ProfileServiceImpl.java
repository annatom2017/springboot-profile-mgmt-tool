package com.pmt.services;

import com.pmt.entities.Profile;
import com.pmt.repositories.AddressRepository;
import com.pmt.repositories.ProfileRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Product service implementation layer
 * DTO --> entity copy done here.
 */
@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	AddressRepository addressRepository;

	@Override
	public List<Profile> listAllUsers() {
		return profileRepository.findAll();
	}

	@Override
	public Profile getUserById(Integer profileId) {
		return profileRepository.findOne(profileId.longValue());
	}

	@Override
	public Profile createUpdateUser(Profile user) {
		return profileRepository.save(user);
	}

	@Override
	public void deleteUser(Profile user) {
		 profileRepository.delete(user.getProfileId().longValue());
	}   
}
