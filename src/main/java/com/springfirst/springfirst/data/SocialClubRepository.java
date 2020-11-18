package com.springfirst.springfirst.data;

import com.springfirst.springfirst.models.SocialClub;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SocialClubRepository extends CrudRepository<SocialClub, Long> {

    List<SocialClub> findByIsPrivate(Integer isPrivate);

}
