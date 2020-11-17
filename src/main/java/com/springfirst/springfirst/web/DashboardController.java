package com.springfirst.springfirst.web;

import com.springfirst.springfirst.data.LocationRepository;
import com.springfirst.springfirst.data.UserRepository;
import com.springfirst.springfirst.models.Location;
import com.springfirst.springfirst.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping ("/dashboard")
public class DashboardController {

    private UserRepository userRepo;
    private LocationRepository locationRepository;

    @Autowired
    public DashboardController ( UserRepository userRepo, LocationRepository locationRepository ) {
        this.userRepo = userRepo;
        this.locationRepository = locationRepository;
    }


    @GetMapping
    public String showDashboard ( Principal principal ) {
        String userName = principal.getName ();
        User user = userRepo.findByUsername ( userName );

        System.out.println ("in the dashboard method");
        System.out.println (user);

        Iterable<Location> locationList = locationRepository.findAll ( Sort.by ( "location" ).ascending ());
        locationList.forEach ( x -> System.out.println (x.getLocation ()) );
        return "dashboard";
    }
}
