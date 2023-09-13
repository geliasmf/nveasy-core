package app.nveasy.service;

import java.util.List;

import app.nveasy.entity.UsersApp;

public interface UserService {
	UsersApp findByUserNameAndPassword(String username, String password);
	List<UsersApp> findAll();
	UsersApp create(UsersApp usersApp);
}
