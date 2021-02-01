package com.ohm.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id
	@Column(name = "roleid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleId;
	
	@Column(name = "rolename")
	@Enumerated(EnumType.STRING)
	private ROLENAME roleName;

	public Role() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Role(ROLENAME roleName) {
		super();
		this.roleName = roleName;
	}
	
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	

	public ROLENAME getRoleName() {
		return roleName;
	}

	public void setRoleName(ROLENAME roleName) {
		this.roleName = roleName;
	}	
	
	
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
}
