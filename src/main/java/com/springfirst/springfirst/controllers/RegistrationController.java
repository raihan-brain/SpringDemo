package com.springfirst.springfirst.controllers;

import com.springfirst.springfirst.repository.UserRepository;
import com.springfirst.springfirst.models.User;
import com.springfirst.springfirst.security.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping ("/register")
public class RegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController (
            UserRepository userRepo, PasswordEncoder pass ) {
        this.userRepository = userRepo;
        this.passwordEncoder = pass;
    }

    @GetMapping
    public String registerForm ( @ModelAttribute("form") RegistrationForm form ) {
        return "registration";
    }

    @PostMapping
    public String processRegistration (
            @Valid @ModelAttribute("form") RegistrationForm form, Errors errors, Model model ) {
        model.addAttribute ( "form", form );
        if ( errors.hasErrors () ) {
//            System.out.println ( "======================= error" );
//            for (FieldError err : errors.getFieldErrors ()) {
//                System.out.println ( err.getField () );
//                System.out.println ( err.getDefaultMessage () );
//            }
            return "registration";
        }
        System.out.println ( form );
        userRepository.save ( form.toUser ( passwordEncoder ) );

        Iterable<User> test = userRepository.findAll ( Sort.by ( "username" ).ascending () );
        test.forEach ( x-> System.out.println (x) );
        return "redirect:/login";
    }

}
