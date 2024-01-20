package com.example.donationTrack;

import com.example.donationTrack.entity.Donation;
import com.example.donationTrack.entity.Donor;
import com.example.donationTrack.entity.User;
import com.example.donationTrack.repository.DonationRepository;
import com.example.donationTrack.repository.DonorRepository;
import com.example.donationTrack.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DonationTrackApplication implements CommandLineRunner {
	@Autowired
	private DonationRepository donationRepository;

	@Autowired
	private DonorRepository donorRepository;
	@Autowired
	private UserRepository userRepository;

private static final Logger logger = LoggerFactory.getLogger(DonationTrackApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DonationTrackApplication.class, args);
		logger.info("Donation Application Started");
	}

	@Override
	public void run(String... args) throws Exception {
		Donor donor = new Donor("Ajmal", "Doe");
		Donor donor2 = new Donor("Aj", "Helsinki");
		donorRepository.save(donor);
		donorRepository.save(donor2);

		List<Donation> donors = Arrays.asList(
				new Donation("Berksher", "Charity", "Annual", "A long ago", 1997, 18000, donor),
				new Donation("Bill Gates","Fond", "monthly", "A week ago", 2023, 45000, donor2)

		);
		donationRepository.saveAll(donors);

		userRepository.save(new User("user", "$2y$10$v5IaouonYHihY41a9CSrL.oumcpe5Q/Ib1/6yRqVNHhWtUD16GhVe","USER"));
		userRepository.save(new User("admin", "$2y$10$QwbFl035avp6t7MFv8PSkOi3Ux.h7SHRLzc7sB5qKxHkY9akSrsRC","ADMIN"));

		donationRepository.findAll().forEach(don ->logger.info(don.getCategory()+ " " + don.getAmount()));
		donorRepository.findAll().forEach(d -> logger.info(d.getFirstName() + " " + d.getLastName()));

	}
}
