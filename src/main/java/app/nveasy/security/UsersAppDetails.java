package app.nveasy.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.nveasy.entity.UsersApp;
import app.nveasy.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UsersAppDetails implements UserDetailsService{

	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> authorities = null;
		Optional<UsersApp> userApp = userRepository.findByUsername(username);
		if (!userApp.isPresent()) {
			throw new UsernameNotFoundException("User details not found for the user "+username);
		} else {
			authorities = new ArrayList<GrantedAuthority>();
			authorities.addAll(userApp.get().getRoles().stream().map(r-> new SimpleGrantedAuthority( r.getName())).toList());
		}
		return new User(username, passwordEncoder.encode(userApp.get().password), authorities);
	}
}
