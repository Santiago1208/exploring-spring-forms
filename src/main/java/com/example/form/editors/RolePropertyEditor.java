package com.example.form.editors;

import java.beans.PropertyEditorSupport;

import com.example.form.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolePropertyEditor extends PropertyEditorSupport {

	@Autowired
	private RoleService roleService;
	
	@Override
	public void setAsText(String roleId) throws IllegalArgumentException {
		try {
			Integer id = Integer.parseInt(roleId);
			setValue(roleService.findById(id));
		} catch (NumberFormatException e) {
			setValue(null);
		}
	}

}
