package com.nbc.ecommerceApp.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    static SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests
                        -> requests.requestMatchers("/h2-console/**").permitAll() //h2 console authorization removed
                        .anyRequest().authenticated())  //all endpoints are secured - need authorization
                .sessionManagement(session
                        -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //session creation policy set to stateless
                .csrf(csrf
                        ->csrf.disable()) //disabled for DML/DDL requests
                .headers(header
                        ->header.frameOptions(frames -> frames.sameOrigin())) //enable same origin frame options to display h2 console
                .httpBasic(withDefaults()); //basic authentication is enabled
//        http.formLogin(withDefaults()); //form login disabled
        return http.build();
    }

    /*@Bean
    UserDetailsService getUserDetails() {
        UserDetails user = User.withUsername("user")
                .password(getPasswordEncoder().encode("userpass"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(getPasswordEncoder().encode("adminpass"))
                .roles("ADMIN")
                .build();
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.createUser(user);
        userDetailsManager.createUser(admin);
//        return new InMemoryUserDetailsManager(user, admin);
        return userDetailsManager;
    }*/

    @Bean
    static RoleHierarchy roleHierarchy() {
        return RoleHierarchyImpl.withRolePrefix("")
                .role("ADMIN").implies("STAFF")
                .role("STAFF").implies("USER")
                .role("USER").implies("GUEST")
                .build();
    }

    @Bean
    static MethodSecurityExpressionHandler methodSecurityExpressionHandler(RoleHierarchy roleHierarchy) {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHierarchy);
        return expressionHandler;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
