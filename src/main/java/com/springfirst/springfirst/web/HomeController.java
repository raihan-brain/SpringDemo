package com.springfirst.springfirst.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springfirst.springfirst.data.SocialClubRepository;
import com.springfirst.springfirst.models.SocialClub;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private SocialClubRepository socialRepo;

	public HomeController(SocialClubRepository socialRepo) {
		this.socialRepo = socialRepo;
	}


	@GetMapping
	public String showHomePage( Model model ) {
		System.out.println("running home controller");

		List<SocialClub> nonPrivateStatusList = socialRepo.findByIsPrivate(0);

		nonPrivateStatusList.stream().forEach(x -> System.out.println(x.getStatus()));

		model.addAttribute ( "socialClub", nonPrivateStatusList );
		System.out.println (model);
		return "home";
	}

}
