package com.example.donationTrack;

import com.example.donationTrack.entity.Donor;
import com.example.donationTrack.repository.DonateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DonationTrackApplication implements CommandLineRunner {
	@Autowired
	private DonateRepository donateRepository;


private static final Logger logger = LoggerFactory.getLogger(DonationTrackApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DonationTrackApplication.class, args);
		logger.info("Donation Application Started");
	}

	@Override
	public void run(String... args) throws Exception {
		Donor donor = new Donor();

	}
}
