package com.oyorooms.model.dto;

public class ModuleDTO {

	private Long id;
	private String moduleName;
	private String readAction;
	private String writeAction;

	public ModuleDTO(Long id, String moduleName, String readAction, String writeAction) {
		super();
		this.id = id;
		this.moduleName = moduleName;
		this.readAction = readAction;
		this.writeAction = writeAction;

	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
