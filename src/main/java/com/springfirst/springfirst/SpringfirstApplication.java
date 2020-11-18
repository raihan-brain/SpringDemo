package com.springfirst.springfirst;

import com.springfirst.springfirst.data.LocationRepository;
import com.springfirst.springfirst.models.Location;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringfirstApplication {

    public static void main ( String[] args ) {
        SpringApplication.run ( SpringfirstApplication.class, args );
    }

    @Bean
    public CommandLineRunner dataLoader ( LocationRepository locationRepository ) {
        return new CommandLineRunner () {
            @Override public void run ( String... args ) throws Exception {
                locationRepository.save ( new Location (1L, "Sylhet") );
                locationRepository.save ( new Location (2L, "Bandarban") );
                locationRepository.save ( new Location (3L, "Khulna") );
            }
        };
    }

}
