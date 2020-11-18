package com.springfirst.springfirst.web;

import com.springfirst.springfirst.data.LocationRepository;
import com.springfirst.springfirst.data.SocialClubRepository;
import com.springfirst.springfirst.data.UserRepository;
import com.springfirst.springfirst.models.Location;
import com.springfirst.springfirst.models.SocialClub;
import com.springfirst.springfirst.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	private UserRepository userRepo;
	private LocationRepository locationRepository;
	private SocialClubRepository socialClubRepository;

	@Autowired
	public DashboardController(UserRepository userRepo, LocationRepository locationRepository,
			SocialClubRepository socialRepo) {
		this.userRepo = userRepo;
		this.locationRepository = locationRepository;
		this.socialClubRepository = socialRepo;
	}

	@ModelAttribute(name = "social")
	public SocialClub social() {
		return new SocialClub();
	}

	// @ModelAttribute(name = "locations")
	// public Location locations() {
	// return new Location ( )
	// }

	@GetMapping
	public String showDashboard(Principal principal, Model model) {
		String userName = principal.getName();
		User user = userRepo.findByUsername(userName);

		// System.out.println ( "in the dashboard method" );
		// System.out.println ( user );

		Iterable<Location> locationList = locationRepository.findAll(Sort.by("location").ascending());

		model.addAttribute("locations", locationList);
		model.addAttribute(user);
		// System.out.println ( model );

		return "dashboard";
	}

	@PostMapping
	public String processSocial(@Valid @ModelAttribute("social") SocialClub social, Errors errors,
			@AuthenticationPrincipal User user) {

		if (errors.hasErrors()) {
			System.out.println(errors);
			return "dashboard";
		}

		List<SocialClub> test2 = this.socialClubRepository.findByUser(user);

		if (social.getPinStatus() == 1) {
			test2.stream().forEach(x -> {
				x.setPinStatus(0);
				this.socialClubRepository.save(x);
			});
		}

		social.setUser(user);
		this.socialClubRepository.save(social);

		return "redirect:/";
	}
}
