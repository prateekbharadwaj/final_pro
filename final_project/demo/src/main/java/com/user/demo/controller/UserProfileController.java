package com.user.demo.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.demo.dto.LoginDTO;
import com.user.demo.dto.UserProfileDTO;
import com.user.demo.entity.UserProfile;
import com.user.demo.service.UserService;
import com.user.demo.service.UserServiceImpl;

@RestController
public class UserProfileController {
	@Autowired
    private UserService userService;
	
    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserProfile> getUser(@PathVariable("id") int userId) {
    	UserProfile userProfile = new UserProfile();
    	UserProfileDTO userDTO = userService.getUserByUserId(userId);
    	BeanUtils.copyProperties(userProfile, userDTO);
    	return ResponseEntity.ok(userProfile);
    }
    
    @PostMapping()
	public ResponseEntity<UserProfileDTO> createUser(@RequestBody @Valid UserProfileDTO dto) throws Exception{
				
    	return ResponseEntity.ok(userService.createUser(dto));
	}
   
    @PostMapping(path = "/login")
    public ResponseEntity<String> login( LoginDTO logindto){
    	int userId = logindto.getUserId();
    	String password = logindto.getPassword();
    	String msg = userService.login(userId, password);
    	return ResponseEntity.ok(msg);
    }
    
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int userId)  throws Exception{
    	String msg = userService.deleteUserByUserId(userId);
    	return ResponseEntity.ok(msg);
    }
    


}
