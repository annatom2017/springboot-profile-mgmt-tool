package com.pmt.services.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pmt.entities.Profile;
import com.pmt.repositories.ProfileRepository;
import com.pmt.entities.Address;
import com.pmt.services.ProfileServiceImpl;

import mockit.Injectable;
import mockit.NonStrictExpectations;
import mockit.Tested;
import mockit.integration.junit4.JMockit;


@RunWith(JMockit.class)
public class ProfileServiceTest {
	public static final Logger LOGGER = LoggerFactory.getLogger(ProfileServiceTest.class);
	@Tested  
	ProfileServiceImpl profileService;
	@Injectable
	ProfileRepository profileRepository;
	List<Profile> users;
	Profile user;
	Long id=100L;
	
	@Before
	public void setUp(){
		users=new ArrayList<>();
		user=new Profile();
		List<Address> addressList=new ArrayList<>();
		Address address1=new Address(110, "HOME", "Address 1 , my Street, XXX");
		addressList.add(address1);
		address1=new Address(120, "OFFICE", "Address 2 , my Street2, XXXYY");
		addressList.add(address1);
		user =new Profile();
		user.setFirstName("First");
		user.setLastName("last");
		user.setDob(new Date());
		user.setEmail("xxx@yahoo.com");
		user.setAddress(addressList);	}

	@Test
	public void testListAllUsers(){
		new NonStrictExpectations() {
			{
				profileRepository.findAll();
				returns(users);
			}			
		};
		List<Profile> userList=profileService.listAllUsers();
		Assert.assertNotNull(userList);
		}
	@Test
	public void testGetUserById(){
		new NonStrictExpectations() {
			{
				profileRepository.findOne(id);
				returns(user);
			}			
		};
		Profile user=profileService.getUserById(Integer.valueOf(100));
		Assert.assertNotNull(user);


	}
	@Test
	public void testCreateUpdateUser(){
		List<Address> addressList=new ArrayList<>();
		Address address1=new Address(110, "HOME", "Address 1 , my Street, XXX");
		addressList.add(address1);
		address1=new Address(120, "OFFICE", "Address 2 , my Street2, XXXYY");
		addressList.add(address1);
		Profile user1 =new Profile();
		user1.setFirstName("First");
		user1.setLastName("last");
		user1.setDob(new Date());
		user1.setEmail("xxx@yahoo.com");
		user1.setAddress(addressList);
		new NonStrictExpectations() {
			{
				profileRepository.save(user1);
				returns(user);
			}			
		};
		
		Profile userUpdated=profileService.createUpdateUser(user);  

	}
	@Test
	public void testDeleteUser(){
		Profile user =new Profile();
		user.setProfileId(100);
		new NonStrictExpectations() {
			{
				profileRepository.delete(100L);				
			}			
		};
		profileService.deleteUser(user);
	}


}
