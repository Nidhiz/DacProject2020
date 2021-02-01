package com.ohm.service;

import java.util.List;

import com.ohm.pojos.ROLENAME;
import com.ohm.pojos.User;

public interface IUserService {

	List<User> getUserByRole(ROLENAME roleName);

	String deleteSupplier(Long sid);
	
	Long countUserbyRole(ROLENAME roleName);

}
