package app.nveasy.service;

import java.util.Optional;
import app.nveasy.entity.Role;

public interface RoleService {
	Optional<Role> findByName(String name);
}
