package com.oyorooms.model.request;

import java.io.Serializable;
import java.util.List;

public class UpdatedRoleEntity implements Serializable {

	private static final long serialVersionUID = -7641493390639214732L;
	private Long id;
	private String roleName;
	private String description;
	private List<UpdatedModule> module = null;

	public List<UpdatedModule> getModule() {
		return module;
	}

	public void setModule(List<UpdatedModule> module) {
		this.module = module;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UpdatedRoleEntity [roleName=" + roleName + ", description=" + description + "]";
	}

}
