package com.spring.university;

import com.spring.university.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Response {
    private int status;
    private boolean success;
    private String message;
    private Object data;
    private String token;
    private String  expirationTime;
    private String role;


    private User user;
    private List<User> userList;

}
