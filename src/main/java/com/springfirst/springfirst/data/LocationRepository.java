package com.springfirst.springfirst.data;

import com.springfirst.springfirst.models.Location;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;


public interface LocationRepository extends CrudRepository<Location , Long> {

    Iterable<Location> findAll( Sort sort );


}
