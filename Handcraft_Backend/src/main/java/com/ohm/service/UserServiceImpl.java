package com.ohm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ohm.pojos.Product;
import com.ohm.pojos.ROLENAME;
import com.ohm.pojos.User;
import com.ohm.repository.IProductRepository;
import com.ohm.repository.IUserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository urepo;
	
	@Override
	public List<User> getUserByRole(ROLENAME roleName) {
		List<User> u=urepo.findAllByRole(roleName);
		return u;
	}

	@Override
	public String deleteSupplier(Long sid) {
		urepo.deleteById(sid);
		return "Product with ID=" + sid + " deleted...";
	}

	@Override
	public Long countUserbyRole(ROLENAME roleName) {
		return urepo.countByRole(roleName);
	}
}
