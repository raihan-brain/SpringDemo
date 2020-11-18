package com.springfirst.springfirst;

import com.springfirst.springfirst.data.LocationRepository;
import com.springfirst.springfirst.data.UserRepository;
import com.springfirst.springfirst.models.Location;
import com.springfirst.springfirst.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Profile("!prod")
@Configuration
public class DevelopmentConfig {

	@Bean
	public CommandLineRunner dataLoader(LocationRepository locationRepository, UserRepository userRepo,
			PasswordEncoder encoder) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				locationRepository.save(new Location(1L, "Sylhet"));
				locationRepository.save(new Location(2L, "Bandarban"));
				locationRepository.save(new Location(3L, "Khulna"));

				userRepo.save(new User("hello1", encoder.encode("Qwer1234@"), "habuma@example.com"));

			}
		};
	}

}
