package org.foxbpm.kernel.runtime.impl;

import org.foxbpm.kernel.runtime.KernelVariableInstance;

public class KernelVariableInstanceImpl implements KernelVariableInstance {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public void delete(){
		
	}

}