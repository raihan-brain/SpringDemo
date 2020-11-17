package com.springfirst.springfirst.security;

import com.springfirst.springfirst.models.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RegistrationForm {

    @NotBlank (message = "User name cannot be blank")
    private String username;
    @NotBlank (message = "Password cannot be empty")
    private String password;
    @NotBlank (message = "Email address cannot be empty")
    @Pattern (regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "email is not in the correct pattern")
    private String email;

    public User toUser ( PasswordEncoder passwordEncoder ){
        return new User (username, passwordEncoder.encode ( password ), email);
    }
}
