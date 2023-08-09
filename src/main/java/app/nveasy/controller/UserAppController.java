package app.nveasy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import app.nveasy.entity.UsersApp;
import app.nveasy.service.UserService;

@RestController
@RequestMapping("/usersApp")
public class UserAppController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public UsersApp loginUser(@RequestParam("userName") String userName, @RequestParam("password") String password) throws Exception {
        UsersApp user = userService.findByUserNameAndPassword(userName, password);
        if (user != null) {
            return user;
        } else {
            throw new Exception("Usuario no encontrado");
        }
    }
    
    @GetMapping("/users")
    public List<UsersApp> getAllUsers() {
        return userService.findAll();
    }
}
