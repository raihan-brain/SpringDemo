package com.springfirst.springfirst.service;

import com.springfirst.springfirst.models.SocialClub;
import com.springfirst.springfirst.models.User;
import com.springfirst.springfirst.repository.SocialClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    private SocialClubRepository socialClubRepository;

    @Autowired
    public DashboardService(SocialClubRepository socialRepo){
        this.socialClubRepository = socialRepo;
    }

    public void updateSocialPinStatus ( SocialClub social, User user ) {

        List<SocialClub> test2 = this.socialClubRepository.findByUser( user);

        if (social.getPinStatus() == 1) {
            test2.stream().forEach(x -> {
                x.setPinStatus(0);
                this.socialClubRepository.save(x);
            });
        }
    }
}
