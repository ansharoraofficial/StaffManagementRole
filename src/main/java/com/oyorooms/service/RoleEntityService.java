package com.oyorooms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyorooms.converter.EntityToDtoConverter;
import com.oyorooms.entity.RoleEntity;
import com.oyorooms.errors.NotFoundException;
import com.oyorooms.model.dto.RoleEntityDTO;
import com.oyorooms.model.request.UpdatedModule;
import com.oyorooms.model.request.UpdatedRoleEntity;
import com.oyorooms.repository.ModuleRepository;
import com.oyorooms.repository.RoleEntityRepository;

@Service
public class RoleEntityService {

	@Autowired
	private RoleEntityRepository roleEntityRepository;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private ModuleRepository moduleRepository;

	public void addRoles(List<UpdatedRoleEntity> roleEntity) {

		for (UpdatedRoleEntity roleObj : roleEntity) {
			RoleEntity role = addRoleEntity(roleObj);
			// System.out.println(role.getDescription());

			if (roleObj.getModule() != null) {
				moduleService.addModule(role.getId(), roleObj.getModule());
			}
		}
	}
	
	Long findIdByName(String name) {
		return roleEntityRepository.findIdByName(name);
	}

	@Transactional
	private RoleEntity addRoleEntity(UpdatedRoleEntity roleObj) {
		RoleEntity role = new RoleEntity();
		role.setRoleName(roleObj.getRoleName());
		role.setDescription(roleObj.getDescription());

		return roleEntityRepository.save(role);
	}

	public List<RoleEntityDTO> getAllRoles() {
		// List<RoleEntity> roleEntity = roleEntityRepository.findAll();

		List<RoleEntityDTO> roleEntityDTO = new ArrayList<>();
		List<RoleEntity> roleEntity = roleEntityRepository.findAll();

		for (RoleEntity role : roleEntity) {
			RoleEntityDTO roleDTO = EntityToDtoConverter.map(role, RoleEntityDTO.class);

			roleEntityDTO.add(roleDTO);
		}
		return roleEntityDTO;
	}

	public RoleEntity getRoleByName(String roleName) {
		Long id = findIdByName(roleName);
		if(id == null) return null;
		
		Optional<RoleEntity> roleId = roleEntityRepository.findById(id);
		if (roleId.isPresent()) {
			return roleId.get();
		} else {
			throw new NotFoundException("Role Not found with name " + roleName);
		}

	}

	public void updateRoleEntity(String roleName, @Valid UpdatedRoleEntity roleEntity) {

		Long id = findIdByName(roleName);
		if(id == null) return;
		Optional<RoleEntity> role = roleEntityRepository.findById(id);
		if (role.isPresent()) {
			
			if (!roleEntity.getDescription().isEmpty()) {

				role.get().setDescription(roleEntity.getDescription());

			}

			if (roleEntity.getModule() != null) {

				for (UpdatedModule moduleObj : roleEntity.getModule()) {
					Long moduleId = moduleRepository.getModuleIdByName(moduleObj.getModuleName(), id);
					if (moduleId != null) {
						moduleService.updateModule(moduleId, moduleObj);
					} else {
						List<UpdatedModule> moduleList = new ArrayList<>();
						moduleList.add(moduleObj);
						moduleService.addModule(id, moduleList);
					}

				}
			}

			roleEntityRepository.save(role.get());

		} else {
			throw new NotFoundException("Role Not found with Id " + id);
		}
	}

	public String deleteRole(String roleName) {

		Long id = findIdByName(roleName);
		if(id == null) return null;
		return roleEntityRepository.findById(id).map(role -> {
			roleEntityRepository.delete(role);
			return "Deleted Successfully";
		}).orElseThrow(() -> new NotFoundException("Role Not Found With Id " + id));
	}

}
