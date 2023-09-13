package app.nveasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.nveasy.entity.UsersApp;
import app.nveasy.service.UserService;

@RestController
@RequestMapping("/usersApp")
public class UserAppController {

	@Autowired
	private UserService userService;

//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private RoleService roleService;
//
//	@Autowired
//	private PasswordEncoder encoder;
//
//	@Autowired
//	JwtUtils jwtUtils;

//	@GetMapping("/login")
//	public UsersApp loginUser(@RequestParam("userName") String userName, @RequestParam("password") String password)
//			throws Exception {
////    	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
////
////    	    SecurityContextHolder.getContext().setAuthentication(authentication);
////
////    	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
////
////    	    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
////
////    	    List<String> roles = userDetails.getAuthorities().stream()
////    	        .map(item -> item.getAuthority())
////    	        .collect(Collectors.toList());
////
////    	    return userDetails;
////    	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
////    	        .body(new UserInfoResponse(userDetails.getId(),
////    	                                   userDetails.getUsername(),
////    	                                   userDetails.getEmail(),
////    	                                   roles));
//		UsersApp user = userService.findByUserNameAndPassword(userName, password);
//		if (user != null) {
//			return user;
//		} else {
//			throw new Exception("Usuario no encontrado");
//		}
//	}

	@GetMapping("/users")
	public List<UsersApp> getAllUsers() {
		return userService.findAll();
	}
}
