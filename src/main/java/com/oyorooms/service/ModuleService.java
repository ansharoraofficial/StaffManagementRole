package com.oyorooms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyorooms.converter.EntityToDtoConverter;
import com.oyorooms.converter.UpdatedRequestToDTOConverter;
import com.oyorooms.entity.Module;
import com.oyorooms.entity.RoleEntity;
import com.oyorooms.errors.NotFoundException;
import com.oyorooms.model.dto.ModuleDTO;
import com.oyorooms.model.request.UpdatedModule;
import com.oyorooms.repository.ModuleRepository;
import com.oyorooms.repository.RoleEntityRepository;

@Service
public class ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	@Autowired
	private RoleEntityRepository roleEntityRepository;

	public void addModule(Long roleId, @Valid List<UpdatedModule> module) {

		Optional<RoleEntity> role = roleEntityRepository.findById(roleId);
		if (role.isPresent()) {

			for (UpdatedModule moduleObj : module) {

				Module mod = UpdatedRequestToDTOConverter.map(moduleObj, Module.class);
				mod.setRoleEntity(role.get());
				moduleRepository.save(mod);

			}
		} else {
			throw new NotFoundException("Role Not Found");
		}

	}

	public List<ModuleDTO> getModules(Long roleId) {

		List<ModuleDTO> moduleDTO = new ArrayList<>();
		if (roleEntityRepository.existsById(roleId)) {
			List<Module> modules = moduleRepository.findByRoleEntityId(roleId);
			for (Module modObj : modules) {

				ModuleDTO mod = EntityToDtoConverter.map(modObj, ModuleDTO.class);
				moduleDTO.add(mod);

			}
		} else {
			throw new NotFoundException("Role id not found");
		}
		return moduleDTO;
	}

//	public String getReadAction(String moduleName) {
//		return moduleRepository.findReadActionByModuleName(moduleName);
//	}
//
//	public String getWriteAction(String moduleName) {
//		return moduleRepository.findWriteActionByModuleName(moduleName);
//	}

	public String getModuleByAction(String action) {
		return moduleRepository.getModuleByAction(action);
	}

	public void updateModule(Long moduleId, @Valid UpdatedModule UpdatedModule) {

		Module module = UpdatedRequestToDTOConverter.map(UpdatedModule, Module.class);
		Optional<Module> oldModule = moduleRepository.findById(moduleId);
		if (oldModule.isPresent()) {
			if (!module.getModuleName().isEmpty()) {
				oldModule.get().setModuleName(module.getModuleName());
			}
			if (!module.getReadAction().isEmpty()) {
				oldModule.get().setReadAction(module.getReadAction());
			}
			if (!module.getWriteAction().isEmpty()) {
				oldModule.get().setWriteAction(module.getWriteAction());
			}
			moduleRepository.save(oldModule.get());
		} else {
			throw new NotFoundException("Role Not found with Id " + moduleId);
		}
	}

	public List<String> getActions(String moduleName) {
		List<String> actions = new ArrayList<>();
		actions.add(moduleRepository.findReadActionByModuleName(moduleName));
		actions.add(moduleRepository.findWriteActionByModuleName(moduleName));
		return actions;
	}

}
