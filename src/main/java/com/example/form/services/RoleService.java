package com.example.form.services;

import java.util.List;

import com.example.form.model.domain.Role;

public interface RoleService {
	
	public List<Role> getRoles();

	public Role findById(Integer id);

}
