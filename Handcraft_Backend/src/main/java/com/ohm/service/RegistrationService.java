package com.ohm.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohm.pojos.AESAlgorithm;
import com.ohm.pojos.ROLENAME;
import com.ohm.pojos.Role;
import com.ohm.pojos.User;
import com.ohm.repository.IRoleRepository;
import com.ohm.repository.IUserRepository;

@Service
public class RegistrationService {

	@Autowired
	private IUserRepository repo;
	
	
	public User saveUser(User user) throws GeneralSecurityException, IOException {
		user.setPassword(AESAlgorithm.en(user.getPassword()));
		return repo.save(user);

	}

	public User fetchUserByEmail(String email) {
		return repo.findByEmail(email);
	}

	public User fetchUserByEmailAndPassword(String email,String password) throws GeneralSecurityException, IOException {
		return repo.findByEmailAndPassword(email, AESAlgorithm.en(password));
	}
	
	

}
