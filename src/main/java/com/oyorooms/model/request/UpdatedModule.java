package com.oyorooms.model.request;

import java.io.Serializable;

public class UpdatedModule implements Serializable {

	private static final long serialVersionUID = 1687222164592477472L;

	private Long id;
	private String moduleName;

	private String readAction;
	private String writeAction;
	private UpdatedRoleEntity roleEntity = null;

	public UpdatedRoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(UpdatedRoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getReadAction() {
		return readAction;
	}

	public void setReadAction(String readAction) {
		this.readAction = readAction;
	}

	public String getWriteAction() {
		return writeAction;
	}

	public void setWriteAction(String writeAction) {
		this.writeAction = writeAction;
	}

}
