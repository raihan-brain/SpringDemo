package com.springfirst.springfirst.data;

import com.springfirst.springfirst.models.SocialClub;
import com.springfirst.springfirst.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SocialClubRepository extends CrudRepository<SocialClub, Long> {

    List<SocialClub> findByIsPrivate(Integer isPrivate);

    List<SocialClub> findByUser( User user );

}
