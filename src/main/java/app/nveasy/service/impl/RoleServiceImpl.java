package app.nveasy.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.nveasy.entity.Role;
import app.nveasy.repository.RoleRepository;
import app.nveasy.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService
{
	@Autowired
	RoleRepository roleRep;

	@Override
	public Optional<Role> findByName(String name) {
		return roleRep.findByName(name);
	}
}
