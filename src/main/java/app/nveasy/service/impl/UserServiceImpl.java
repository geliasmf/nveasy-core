package app.nveasy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.nveasy.entity.UsersApp;
import app.nveasy.repository.UserRepository;
import app.nveasy.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository userRep;
	
	@Override
	public UsersApp findByUserNameAndPassword(String username, String password) {
		return userRep.findByUserNameAndPassword(username, password);
	}

	@Override
	public List<UsersApp> findAll() {
		return userRep.findAll();
	}

	@Override
	public UsersApp create(UsersApp usersApp) {
		return userRep.save(usersApp);
	}
}
