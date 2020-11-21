package com.springfirst.springfirst.controllers;

import com.springfirst.springfirst.repository.SocialClubRepository;
import com.springfirst.springfirst.models.SocialClub;
import com.springfirst.springfirst.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	private SocialClubRepository socialRepo;

	@Autowired
	public ProfileController(SocialClubRepository socialRepo) {
		this.socialRepo = socialRepo;
	}

	@GetMapping
	public String showProfile( @AuthenticationPrincipal User user, Model model ) {
		System.out.println("in the showProfile");
		System.out.println(user);

		List<SocialClub> pinnedStatusList = this.socialRepo.findByUserAndPinStatus ( user, 1 );

//		pinnedStatusList.stream ().forEach ( x-> System.out.println (x.getStatus () + " pinned = " + x.getPinStatus () ) );

		List<SocialClub> allStatusList = this.socialRepo.findByUserAndPinStatus ( user, 0 );


		model.addAttribute ( "pinnedStatus", pinnedStatusList );

		model.addAttribute ( "allStatusList", allStatusList );

		model.addAttribute ( "user", user );

		System.out.println (model);


		return "/profile";
	}

}
