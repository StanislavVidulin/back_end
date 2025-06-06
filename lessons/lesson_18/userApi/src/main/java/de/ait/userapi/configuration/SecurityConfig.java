package de.ait.userapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        x -> x
//                                .requestMatchers(HttpMethod.GET, "/products").hasRole("USER")
//                                .requestMatchers(HttpMethod.POST, "/products").hasAnyAuthority("ADMIN", "REDACTOR")
//                                .requestMatchers(HttpMethod.GET, "/categories").permitAll()
//                                .requestMatchers(HttpMethod.POST, "/categories").hasRole("USER")
//                                .requestMatchers(HttpMethod.GET, "/products/{id}").hasAuthority("USER")
//                                .requestMatchers(HttpMethod.POST, "/products/save").hasAnyRole("ADMIN", "REDACTOR")
//                                .requestMatchers(HttpMethod.POST, "/users").permitAll()
//                                .requestMatchers(HttpMethod.GET, "/users").permitAll()
//                                .requestMatchers(HttpMethod.PUT, "/users/{username}/admin").hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.POST, "/users/{id}/roles").permitAll()
                                .requestMatchers(HttpMethod.POST, "/users").permitAll()
                                .requestMatchers(HttpMethod.GET, "/users").hasRole("USER")
                                .requestMatchers(HttpMethod.POST, "/users/{id}/roles").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/categories").hasRole("REDACTOR")
                                .requestMatchers(HttpMethod.POST, "/products").hasRole("REDACTOR")
                                .requestMatchers(HttpMethod.GET, "/products").permitAll()
                                .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
