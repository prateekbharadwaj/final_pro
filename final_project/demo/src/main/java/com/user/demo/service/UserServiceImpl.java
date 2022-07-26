package com.user.demo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.demo.dto.LoginDTO;
import com.user.demo.dto.UserProfileDTO;
import com.user.demo.entity.UserProfile;
import com.user.demo.repository.UserProfileRepository;

@Service
public class UserServiceImpl implements UserService {
     
	 @Autowired
	 private UserProfileRepository userRepo;
	
	 @Override
	public UserProfileDTO getUserByUserId(int userId) {
		UserProfileDTO returnUserDTO = new UserProfileDTO();
		UserProfile userProfileByUserId = userRepo.findByUserId(userId);
		 if (userProfileByUserId == null)
		 { 
			 //throw new UsernameNotFoundException(userId);
		 }
		 BeanUtils.copyProperties(userProfileByUserId, returnUserDTO);
		 
		return returnUserDTO;
	}

	@Override
	public UserProfileDTO createUser(UserProfileDTO dto) throws Exception {
		// TODO Auto-generated method stub
		if(userRepo.findByPersonaldentificationNumber(dto.getPersonalIdentificationNumber())) {
			throw new Exception("User is already present");
		}
		UserProfile userProfile = UserProfileDTO.convertDTOToEntity(dto);
		userRepo.save(userProfile);
		return dto;
	}

	@Override
	public String login(int userId, String password) {
		// TODO Auto-generated method stub
		Optional<UserProfile> optUserProfile = userRepo.findByUserIdAndPassword(userId, password);
		if(!optUserProfile.isEmpty() ) {
			return "Logged in successfully";
		}else {
			return "Invalid username and password";
		}
	}

	@Override
	public String deleteUserByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		UserProfile userProfile = userRepo.findByUserId(userId);
		if( userProfile == null ) {
			throw new Exception("User doesnt exist");
		}
		userRepo.delete(userProfile);
		
		return "User Deleted Successfully";
	}

}
