package com.oyorooms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oyorooms.model.dto.ModuleDTO;
import com.oyorooms.model.request.CreateModelRequest;
import com.oyorooms.service.ModuleService;

@RestController
public class ModuleController {

	@Autowired
	private ModuleService moduleService;

	@PostMapping(value = "/module/{roleName}")
	public void addModule(@PathVariable String roleName, @Valid @RequestBody CreateModelRequest module) {
		Long roleId = moduleService.findIdByName(roleName);
		if(roleId == null) return;
		moduleService.addModule(roleId, module.getModule());
	}

	@GetMapping(value = "/module/{roleName}")
	public List<ModuleDTO> getModules(@PathVariable String roleName) {
		Long roleId = moduleService.findIdByName(roleName);
		if(roleId == null) return  null;
		return moduleService.getModules(roleId);
	}

	@RequestMapping(value = "/module/getaction/{moduleName}")
	public List<String> getActions(@PathVariable String moduleName) {
		return moduleService.getActions(moduleName);
	}

	@RequestMapping(value = "/module/getmodule/{action}")
	public String getModuleByAction(@PathVariable String action) {
		return moduleService.getModuleByAction(action);
	}

//	@PutMapping(value = "module/{module_name}")
//	public void updateModule(@PathVariable("module_name") Long moduleName, @Valid @RequestBody UpdatedModule module) {
//		moduleService.updateModule(moduleName, module);
//	}

}