package com.oyorooms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "role_name" }) }, name = "role_entity")
public class RoleEntity implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "roleEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Module> module;

	public RoleEntity() {
		super();
	}

	public RoleEntity(String roleName, String description, List<Module> module) {
		super();
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

	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", roleName=" + roleName + ", description=" + description + "]";
	}

}
