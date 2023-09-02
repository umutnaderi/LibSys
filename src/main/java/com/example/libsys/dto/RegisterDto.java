package com.example.libsys.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String email;
    private String name;
    private String password;
}