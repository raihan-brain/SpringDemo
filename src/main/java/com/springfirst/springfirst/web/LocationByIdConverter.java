package com.springfirst.springfirst.web;

import com.springfirst.springfirst.data.LocationRepository;
import com.springfirst.springfirst.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LocationByIdConverter implements Converter<Long, Location> {

    private LocationRepository locationRepo;

    @Autowired
    public LocationByIdConverter ( LocationRepository locationRepo ) {
        this.locationRepo = locationRepo;
    }

    @Override public Location convert ( Long id ) {
//        Optional<Location> locations = locationRepo.findById ( id );
//        System.out.println (" in the locationById converter ");
//        System.out.println (locations);
//        return locations.isPresent () ? locations.get () : null;
        return null;
    }
}
