package com.spring.university.service;

import com.spring.university.Response;
import com.spring.university.dto.LoginRequest;
import com.spring.university.dto.UserDto;
import com.spring.university.enums.Role;
import com.spring.university.model.Instructor;
import com.spring.university.model.Student;
import com.spring.university.model.User;
import com.spring.university.repository.InstructorRepo;
import com.spring.university.repository.StudentRepo;
import com.spring.university.repository.UserRepo;
import com.spring.university.security.JwtUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final StudentRepo studentRepo;
    private final InstructorRepo instructorRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public Response registerUser(UserDto registerUserDto) {
        if (userRepo.existsByEmail(registerUserDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        Role role;
        try {
            role = Role.valueOf(registerUserDto.getRole().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid role provided");
        }

        User.UserBuilder userBuilder = User.builder()
                .email(registerUserDto.getEmail())
                .password(passwordEncoder.encode(registerUserDto.getPassword()))
                .role(role);

        if (registerUserDto.getStudentId() != null) {
         Student student=   studentRepo.findById(registerUserDto.getInstructorId()).orElseThrow(() -> new IllegalArgumentException("student not found"));
            userBuilder.student(student);
        }

        if (registerUserDto.getInstructorId() != null) {
            Instructor instructor = instructorRepo.findById(registerUserDto.getInstructorId())
                    .orElseThrow(() -> new IllegalArgumentException("Instructor not found"));
            userBuilder.instructor(instructor);
        }

        User user = userBuilder.build();
        userRepo.save(user);

        return Response.builder()
                .status(200)
                .message("User Successfully Added")
                .user(user)
                .build();
    }

    //login
        public Response loginUser (LoginRequest loginRequest){

            User user = userRepo.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("Email not found"));
            if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                throw new RuntimeException("Password does not match");
            }
            String token = jwtUtils.generateToken(user);

            return Response.builder()
                    .status(200)
                    .message("User Successfully Logged In")
                    .token(token)
                    .expirationTime("6 Month")
                    .role(user.getRole().name())
                    .build();
        }


}