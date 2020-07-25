package com.example.form.services;

import java.util.Arrays;
import java.util.List;

import com.example.form.model.domain.Role;

import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {

	private List<Role> roles;

	public RoleServiceImp() {
		Role r1 = new Role(1, "ROLE_ADMIN", "Administrator");
		Role r2 = new Role(2, "ROLE_USER", "User");
		Role r3 = new Role(3, "ROLE_MODERATOR", "Moderator");
		roles = Arrays.asList(r1, r2, r3);
	}

	@Override
	public List<Role> getRoles() {
		return roles;
	}

	@Override
	public Role findById(Integer id) {
		Role result = null;
		for (int i = 0; i < roles.size() && result == null; i++) {
			Role currentRole = roles.get(i);
			if (currentRole.getId() == id) {
				result = currentRole;
			}
		}
		return result;
	}
	
}
