package com.StudentsManagementSystem.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.StudentsManagementSystem.entity.User;
import com.StudentsManagementSystem.repository.UserRepository;

@Configuration
public class DataInitializer {
@Bean 
CommandLineRunner initAdmin(UserRepository userRepository, PasswordEncoder encoder) {
	return args -> {

        if (userRepository.findByUsername("admin") == null) {
            User u = new User();
            u.setUsername("admin");
            u.setPassword(encoder.encode("admin123"));
            u.setRole("ADMIN");
            userRepository.save(u);
        }
    };
}
}
