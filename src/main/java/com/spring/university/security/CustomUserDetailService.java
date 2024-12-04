package com.spring.university.security;

import com.spring.university.model.User;
import com.spring.university.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user= userRepo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("email not found"));
        return  AuthUser.builder()
                .user(user)
                .build();
    }
}

/*
* user class
* AuthUser implements UserDetails
* custom userdetservice
* jwtUtils generate jwt token
* JwtAuthFilter
* corsConfig
* */