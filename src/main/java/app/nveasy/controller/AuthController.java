package app.nveasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.nveasy.service.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

//	@PostMapping("/signup")
//	public ResponseEntity<String> register(@RequestBody UsersApp usersApp) {
//		UsersApp userRegister = null;
//		ResponseEntity<String> response = null;
//		try {
//			userRegister = userService.create(usersApp);
//			if (userRegister.getId() > 0) {
//				response = ResponseEntity.status(HttpStatus.CREATED)
//						.body("User Successfully register: " + userRegister.username);
//			}
//		} catch (Exception ex) {
//			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body("An Exception ocurred due to " + ex.getMessage());
//		}
//		return response;
//	}
//
//	@RequestMapping("/signin")
//	public ResponseEntity<String> login(@RequestBody UsersApp usersApp) {
//		UsersApp userRegister = null;
//		ResponseEntity<String> response = null;
//		try {
//			userRegister = userService.create(usersApp);
//			if (userRegister.getId() > 0) {
//				response = ResponseEntity.status(HttpStatus.CREATED)
//						.body("User Successfully register: " + userRegister.username);
//			}
//		} catch (Exception ex) {
//			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body("An Exception ocurred due to " + ex.getMessage());
//		}
//		return response;
//	}

}
