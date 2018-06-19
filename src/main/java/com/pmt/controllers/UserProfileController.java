package com.pmt.controllers;

import com.pmt.entities.Profile;
import com.pmt.services.ProfileService;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

/**
 * User controller.
 */
@RestController
@RequestMapping(value = "/app/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserProfileController {
    private ProfileService profileService;
    
    @Autowired
    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }
    
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileController.class);

    /**
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        LOGGER.error("Generic errors");
        return new ResponseEntity<>(new String("Error in UserProfileController :" + exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
    * List all users.
    *
    * @return
    */
   @RequestMapping(value = "/getallusers", method = RequestMethod.GET)
   public ResponseEntity<List<Profile>> loadAllUsers() throws IllegalAccessException, InvocationTargetException {
	    LOGGER.debug("called method loadAllUsers");
		return new ResponseEntity<List<Profile>>( profileService.listAllUsers(), HttpStatus.OK);
	}  
   /**
    * 
    * Get a specific user details
    * @param id
    * @return
    */
   @RequestMapping(value = "getuser/{id}", method = RequestMethod.GET)
   public ResponseEntity<Profile> loadUser(@RequestParam(required = true) Integer id) {
	    LOGGER.debug("called method loadUser"+id);
		return new ResponseEntity<Profile>(profileService.getUserById(id), HttpStatus.OK);
	}   
    /**
     * New user.
     *
     * @return
     */
   @RequestMapping(value = "/saveuser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> createUpdateUser(@Valid @RequestBody Profile user, BindingResult bindingResult) {
	    LOGGER.debug("called method createUpdateUser"+user);
       if (bindingResult.hasErrors()) {
           return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
       }
       return new ResponseEntity<>(profileService.createUpdateUser(user), HttpStatus.OK);
   }
   
    /**
     * Delete user by  id.
     *
     * @param id
     * @return
     */
   @RequestMapping(value = "/deleteuser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> deleteUser(@Valid @RequestBody Profile user, BindingResult bindingResult) {
       if (bindingResult.hasErrors()) {
           return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
       }
	    LOGGER.debug("called method deleteUser"+user);
       if(user.getProfileId()>0){
    	   profileService.deleteUser(user);
       }
       return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
   }

}
