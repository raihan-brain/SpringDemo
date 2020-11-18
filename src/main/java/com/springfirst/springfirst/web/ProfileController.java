package com.springfirst.springfirst.web;

import com.springfirst.springfirst.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@GetMapping
	public String showProfile( @AuthenticationPrincipal User user ) {
		System.out.println ("in the showProfile");
		System.out.println (user);
		return "/profile";
	}

}
