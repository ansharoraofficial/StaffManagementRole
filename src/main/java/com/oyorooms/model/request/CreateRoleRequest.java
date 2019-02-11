package com.oyorooms.model.request;

import java.util.List;

public class CreateRoleRequest {

	private List<UpdatedRoleEntity> roleEntity;

	public List<UpdatedRoleEntity> getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(List<UpdatedRoleEntity> roleEntity) {
		this.roleEntity = roleEntity;
	}

}
