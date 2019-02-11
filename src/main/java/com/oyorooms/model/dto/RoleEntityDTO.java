package com.oyorooms.model.dto;

import java.util.List;

import com.oyorooms.entity.Module;

public class RoleEntityDTO {

	private Long id;
	private String roleName;
	private String description;
	private List<Module> module;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public RoleEntityDTO(Long id, String roleName, String description, List<Module> module) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.description = description;
		this.module = module;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}

}
