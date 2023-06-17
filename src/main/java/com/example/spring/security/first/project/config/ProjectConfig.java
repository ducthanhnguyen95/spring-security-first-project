package com.example.spring.security.first.project.config;

import com.example.spring.security.first.project.security.CustomAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    private final CustomAuthenticationProvider authenticationProvider;


    public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*All the requests require authentication.*/
        http.httpBasic(Customizer.withDefaults()).authorizeHttpRequests((authz) -> authz.anyRequest().authenticated());

        /*None of the requests need to be authenticated.
         * http.httpBasic(Customizer.withDefaults()).authorizeHttpRequests((authz) -> authz.anyRequest().permitAll());
         * */

        return http.build();
    }
}
