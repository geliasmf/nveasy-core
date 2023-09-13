
package app.nveasy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Value("${cors.allowedOrigins}")
	String corsOrigins;
 
	@Bean
	public WebMvcConfigurer corsMappingConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(corsOrigins).allowedMethods("GET", "PUT", "POST", "DELETE")
						.allowedHeaders("Origin", "Content-Type", "Accept", "Authorization");
				;
			}
		};
	}

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults())
        .csrf(csrf -> csrf.disable())
        .headers(header-> header.frameOptions(h-> h.disable()))
            .authorizeHttpRequests(authorize -> 
                authorize
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                	.requestMatchers("/resources/**","/images/**","/css/**","/js/**","/WEB-INF/views/**").permitAll()
                	.requestMatchers("/h2-ui/**").permitAll()
////                	.requestMatchers("/usersApp/login").anonymous()
////                    
////                    .requestMatchers("/usersApp/users", "/investments/**").authenticated()
                    .anyRequest().authenticated()) // Todas las demás rutas requieren autenticación
            .formLogin(login-> 
            	login
            		.loginPage("/auth/login")
            		.loginProcessingUrl("/auth/login")
            	    .defaultSuccessUrl("/auth/home")
            	    .failureUrl("/auth/login?error=true")
            		.permitAll())
            .logout(
                    logout -> logout
                            .logoutUrl("/logout")
                            .permitAll())
            ;
//            .httpBasic(Customizer.withDefaults()); // Habilitar el formulario de inicio de sesión por defecto de Spring Security       
//;
        return http.build();
		
//		 http
//         .authorizeRequests()
////             .requestMatchers("/resources/**").permitAll() 
//             .anyRequest().authenticated()
//             .and()
////         .formLogin(Customizer.withDefaults())
//         .formLogin()
//             .loginPage("/login/")
//             .permitAll()
//             .and()
//         .logout();
//
//		 return http.build();
    } 
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}