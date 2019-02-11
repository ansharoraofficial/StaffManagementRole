package com.oyorooms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "module")
public class Module implements Serializable {
	private static final long serialVersionUID = 5869721517700392866L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "module_name")
	private String moduleName;

	@Column(name = "read_action")
	private String readAction;

	@Column(name = "write_action")
	private String writeAction;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "role_entity_id", nullable = false)
	@JsonIgnore
	private RoleEntity roleEntity;

	public Module() {
		super();
	}

	public Module(String moduleName, String readAction, String writeAction) {
		super();
		this.moduleName = moduleName;
		this.readAction = readAction;
		this.writeAction = writeAction;
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

	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", moduleName=" + moduleName + ", readAction=" + readAction + ", writeAction="
				+ writeAction + "]";
	}

}
