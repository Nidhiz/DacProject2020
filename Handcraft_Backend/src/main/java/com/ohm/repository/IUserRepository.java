package com.ohm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ohm.pojos.ROLENAME;
import com.ohm.pojos.User;

@Repository									
public interface IUserRepository extends JpaRepository<User, Long> {

		public User findByEmail(String email);
		public User findByEmailAndPassword(String email, String password);
		public List<User> findAllByRole(ROLENAME roleName);
		public Long countByRole(ROLENAME roleName);
}
