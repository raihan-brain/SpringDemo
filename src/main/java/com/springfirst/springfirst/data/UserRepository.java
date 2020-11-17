package com.springfirst.springfirst.data;

import com.springfirst.springfirst.models.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

	Iterable<User> findAll( Sort sort );
}
