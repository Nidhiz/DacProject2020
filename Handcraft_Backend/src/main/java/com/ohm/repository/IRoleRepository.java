package com.ohm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ohm.pojos.ROLENAME;
import com.ohm.pojos.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    public Role findByRoleName(ROLENAME roleName);
}