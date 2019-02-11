package com.oyorooms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oyorooms.entity.RoleEntity;
import com.oyorooms.model.dto.RoleEntityDTO;
import com.oyorooms.model.request.CreateRoleRequest;
import com.oyorooms.model.request.UpdatedRoleEntity;
import com.oyorooms.service.RoleEntityService;

@RestController
public class RoleEntityController {

	@Autowired
	private RoleEntityService roleEntityService;

	@RequestMapping(value = "/role", method = RequestMethod.POST)
	public void addRoles(@RequestBody CreateRoleRequest request) {
		roleEntityService.addRoles(request.getRoleEntity());
	}

	@RequestMapping(value = "/role")
	public List<RoleEntityDTO> getAllRoles() {
		return roleEntityService.getAllRoles();
	}

	@RequestMapping(value = "/role/{id}")
	public RoleEntity getRoleById(@PathVariable Long id) {
		return roleEntityService.getRoleById(id);
	}

	@PutMapping(value = "/role/{id}")
	public void updateRoleEntity(@PathVariable Long id, @Valid @RequestBody UpdatedRoleEntity roleEntity) {
		roleEntityService.updateRoleEntity(id, roleEntity);
	}

	@DeleteMapping(value = "/role/{id}")
	public String deleteRole(@PathVariable Long id) {
		return roleEntityService.deleteRole(id);
	}

}
