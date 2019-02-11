package com.oyorooms.model.request;

import java.util.List;

public class CreateModelRequest {

	private List<UpdatedModule> module;

	public List<UpdatedModule> getModule() {
		return module;
	}

	public void setModule(List<UpdatedModule> module) {
		this.module = module;
	}

}
